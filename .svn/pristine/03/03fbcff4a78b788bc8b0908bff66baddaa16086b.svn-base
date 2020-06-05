package com.huatec.edu.mobileshop.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatec.edu.mobileshop.dao.GoodsCatDao;
import com.huatec.edu.mobileshop.dao.GoodsDao;
import com.huatec.edu.mobileshop.entity.GoodsCat;
import com.huatec.edu.mobileshop.entity.brief.BriefGoods;
import com.huatec.edu.mobileshop.util.MSUtil;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class GoodsCatServiceImpl implements GoodsCatService {
	@Resource
	private GoodsCatDao goodsCatDao;
	@Resource
	private GoodsDao goodsDao;
	//新增分类
	public Result addCat(String name, int parentId, int typeId) {
		Result result=new Result();
		//判断是否存在此分类
		GoodsCat gc=goodsCatDao.findByName(name);
		if(gc!=null){
			result.setStatus(1);
			result.setMsg("已经存在此分类");
			return result;
		}
		if(parentId!=0){
			GoodsCat parentGC=goodsCatDao.findById(parentId);
			//判断父分类是否存在
			if(parentGC==null){
				result.setStatus(1);
				result.setMsg("父分类不存在");
				return result;
			}
			//判断父分类是否可用
			if(parentGC.getList_show()!=0){
				result.setStatus(1);
				result.setMsg("父分类不可用");
				return result;
			}
		}
		//没有父id，parentId=0
		//cat_path问题 格式： 0,1,2
		//注意：cat_path是为了方便观察，不是必须字段
		String catPath;
		if(parentId==0){
			//没有父id，cat_path的格式为 0,n
			//找到n的值
			List<GoodsCat> gcs1=goodsCatDao.findByCatPathDESC(3);
			//降序排列，取第一个元素的cat_path
			String path1=gcs1.get(0).getCat_path();
			//以逗号将path1拆分为字符串数组
			String[] pathes1=path1.split(",");
			//取数组中最后一个值
			int pathLength1=Integer.parseInt(pathes1[1]);
			pathLength1++;
			catPath="0,"+pathLength1;
		}else{
			GoodsCat checkGC=goodsCatDao.findById(parentId);
			if(checkGC.getParent_id()!=0){
				result.setStatus(1);
				result.setMsg("此分类不是顶级分类，不能在其下添加分类");
				return result;
			}
			List<GoodsCat> gcs2=goodsCatDao.findByParentIdDESC(parentId);
			if(gcs2.isEmpty()){
				catPath=checkGC.getCat_path()+",1";
			}else{
				String[] pathes2=gcs2.get(0).getCat_path().split(",");
				int pathLength2=Integer.parseInt(pathes2[2]);
				pathLength2++;
				catPath=checkGC.getCat_path()+","+pathLength2;
			}
		}
		GoodsCat goodsCat=new GoodsCat();
		goodsCat.setCat_id(null);
		goodsCat.setName(name);
		goodsCat.setParent_id(parentId);
		goodsCat.setCat_path(catPath);
		goodsCat.setGoods_count(0);
		goodsCat.setSort(0);//默认没有排序
		goodsCat.setType_id(typeId);
		goodsCat.setList_show(0);//默认可以显示
		goodsCat.setImage("");
		goodsCat.setCreatime(null);
		goodsCat.setModifytime(null);
		goodsCatDao.save(goodsCat);
		result.setStatus(0);
		result.setMsg("新增分类成功");
		result.setData(goodsCat);
		return result;
	}
	//加载顶级分类（和类型表关联查询）
	public Result loadTopCat() {
		Result result=new Result();
		List<GoodsCat> gcs=goodsCatDao.findUnionByParentId(0);
		if(gcs.isEmpty()){
			result.setStatus(1);
			result.setMsg("没有顶级分类");
			result.setData(gcs);
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载顶级分类成功");
		result.setData(gcs);
		return result;
	}
	//根据父id加载二级分类（和类型表关联查询）
	public Result loadCatByParentId(int parentId) {
		Result result=new Result();
		if(parentId==0){
			result.setStatus(1);
			result.setMsg("此父id不合理");
			return result;
		}
		List<GoodsCat> gcs=goodsCatDao.findUnionByParentId(parentId);
		if(gcs.isEmpty()){
			result.setStatus(1);
			result.setMsg("此分类下没有二级分类");
			result.setData(gcs);
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载子分类成功");
		result.setData(gcs);
		return result;
	}
	//加载”可显示到列表“的顶级分类
	public Result loadShowTopCat() {
		Result result=new Result();
		GoodsCat goodsCat=new GoodsCat();
		goodsCat.setParent_id(0);
		goodsCat.setList_show(0);
		List<GoodsCat> gcs=goodsCatDao.dynamicFind(goodsCat);
		if(gcs.isEmpty()){
			result.setStatus(1);
			result.setMsg("没有顶级分类");
			result.setData(gcs);
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载可显示的顶级分类成功");
		result.setData(gcs);
		return result;
	}
	//根据父id加载”可显示到列表“的二级分类
	public Result loadShowCatByParentId(int parentId) {
		Result result=new Result();
		if(parentId==0){
			result.setStatus(1);
			result.setMsg("此父id不合理");
			return result;
		}
		GoodsCat goodsCat=new GoodsCat();
		goodsCat.setParent_id(parentId);
		goodsCat.setList_show(0);
		List<GoodsCat> gcs=goodsCatDao.dynamicFind(goodsCat);
		if(gcs.isEmpty()){
			result.setStatus(1);
			result.setMsg("此分类下没有可显示的二级分类");
			result.setData(gcs);
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载可显示的二级分类成功");
		result.setData(gcs);
		return result;
	}
	//根据id加载分类
	public Result loadCatById(int catId) {
		Result result=new Result();
		GoodsCat goodsCat=goodsCatDao.findById(catId);
		if(goodsCat==null){
			result.setStatus(1);
			result.setMsg("不存在此分类");
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载分类信息成功");
		result.setData(goodsCat);
		return result;
	}
	//根据id加载分类（关联查询）
	public Result loadUnionCatById(int catId) {
		Result result=new Result();
		GoodsCat goodsCat=goodsCatDao.findUnionById(catId);
		if(goodsCat==null){
			result.setStatus(1);
			result.setMsg("不存在此分类");
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载分类信息成功");
		result.setData(goodsCat);
		return result;
	}
	//根据id更新
	public Result updateCat(int catId, String name, int sort, int typeId, 
			int list_show, String image) {
		Result result=new Result();
		GoodsCat checkGC=goodsCatDao.findById(catId);
		if(checkGC==null){
			result.setStatus(1);
			result.setMsg("不存在此分类");
			return result;
		}
		GoodsCat checkGC2=goodsCatDao.findByName(name);
		if(checkGC2!=null){
			result.setStatus(1);
			result.setMsg("已经存在此分类名称");
			return result;
		}
		GoodsCat goodsCat=new GoodsCat();
		goodsCat.setCat_id(catId);
		goodsCat.setName(name);
		goodsCat.setSort(sort);
		goodsCat.setType_id(typeId);
		goodsCat.setList_show(list_show);
		goodsCat.setImage(image);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		goodsCat.setModifytime(now);
		goodsCatDao.dynamicUpdate(goodsCat);
		result.setStatus(0);
		result.setMsg("更新分类信息成功");
		return result;
	}
	//根据id更新image（设置图片）
	public Result updateImage(int catId, String img, String url) {
		Result result=new Result();
		GoodsCat checkGC=goodsCatDao.findById(catId);
		if(checkGC==null){
			result.setStatus(1);
			result.setMsg("不存在此分类");
			return result;
		}
		//转换图片尺寸，80*80
		String[] s=img.split("\\.");// "."用"\\."表示
		String image=s[0]+"_cat."+s[1];
		MSUtil.resizeImage(img, image, 80, 80);
		String path=MSUtil.getPath();
		String catImage=image.replace(path, url);
		GoodsCat goodsCat=new GoodsCat();
		goodsCat.setCat_id(catId);
		//将资源路径中的\替换为/
		goodsCat.setImage(catImage.replace("\\", "/"));
		goodsCatDao.dynamicUpdate(goodsCat);
		//将原图删除
		MSUtil.deleteFile(img);
		result.setStatus(0);
		result.setMsg("设置分类图片成功");
		return result;
	}
	//根据id删除
	public Result deleteCatById(int catId) {
		Result result=new Result();
		//获取父id
		int parentId=goodsCatDao.findById(catId).getParent_id();
		//如果父id为0，说明是顶级分类
		if(parentId==0){
			//判断此顶级分类下是否有子分类
			List<GoodsCat> gcs=goodsCatDao.findByParentIdDESC(catId);
			if(!gcs.isEmpty()){
				result.setStatus(1);
				result.setMsg("此分类下包含子分类，不能删除");
				return result;
			}
		}
		//判断分类下是否有商品
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("cat_id", catId);
		List<BriefGoods> bgs=goodsDao.dynamicFind(map);
		if(!bgs.isEmpty()){
			result.setStatus(1);
			result.setMsg("此分类下有商品，不能删除");
			return result;
		}
		goodsCatDao.deleteById(catId);
		result.setStatus(0);
		result.setMsg("删除分类成功");
		return result;
	}
	//根据id更新商品数量
	public Result updateGoodsCount(int catId,int flag) {
		Result result=new Result();
		GoodsCat gc=goodsCatDao.findById(catId);
		if(gc==null){
			result.setStatus(1);
			result.setMsg("不存在此分类");
			return result;
		}
		//更新GoodsCount
		int goodsCount=gc.getGoods_count();
		if(flag==0){
			goodsCount++;
		}else{
			if(goodsCount>0){
				goodsCount--;
			}
		}
		GoodsCat goodsCat=new GoodsCat();
		goodsCat.setCat_id(catId);
		goodsCat.setGoods_count(goodsCount);
		goodsCatDao.dynamicUpdate(goodsCat);
		//更新父分类中的GoodsCount
		int parentId=gc.getParent_id();
		if(parentId!=0){
			GoodsCat parentGC=goodsCatDao.findById(parentId);
			int parentGoodsCount=parentGC.getGoods_count();
			if(flag==0){
				parentGoodsCount++;
			}else{
				if(parentGoodsCount>0){
					parentGoodsCount--;
				}
			}
			GoodsCat parentGoodsCat=new GoodsCat();
			parentGoodsCat.setCat_id(parentId);
			parentGoodsCat.setGoods_count(parentGoodsCount);
			goodsCatDao.dynamicUpdate(parentGoodsCat);
		}
		result.setStatus(0);
		result.setMsg("更新商品数量成功");
		return result;
	}

}
