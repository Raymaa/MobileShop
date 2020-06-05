package com.huatec.edu.mobileshop.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatec.edu.mobileshop.dao.GoodsCatDao;
import com.huatec.edu.mobileshop.dao.GoodsDao;
import com.huatec.edu.mobileshop.dao.GoodsTypeDao;
import com.huatec.edu.mobileshop.dao.TypeBrandDao;
import com.huatec.edu.mobileshop.entity.GoodsCat;
import com.huatec.edu.mobileshop.entity.GoodsType;
import com.huatec.edu.mobileshop.entity.TypeBrand;
import com.huatec.edu.mobileshop.entity.brief.BriefGoods;
import com.huatec.edu.mobileshop.util.Result;

import net.sf.json.JSONObject;
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
	@Resource
	private GoodsTypeDao goodsTypeDao;
	@Resource
	private TypeBrandDao typeBrandDao;
	@Resource
	private GoodsCatDao goodsCatDao;
	@Resource
	private GoodsDao goodsDao;
	//新增类型
	public Result addType(String name, String[] paramsKey,int isPhysical) {
		Result result=new Result();
		//判断是否存在此类型
		GoodsType checkGoodsType=goodsTypeDao.findByName(name);
		if(checkGoodsType!=null){
			result.setStatus(1);
			result.setMsg("已经存在此类型");
			return result;
		}
		//构建参数,最多传递5个
		//因为一个类型的参数有很多，所以采用map的形式
//		Map<String,Object> map2=new HashMap<String,Object>();
		Map<String,Object> map3=new HashMap<String,Object>();
		//循环向map3中增加参数名
		for(int i=0;i<=4;i++){
			if(!"".equals(paramsKey[i])){
				map3.put(paramsKey[i], "");
			}
		}
//		map2.put("params", map3);
		//将map转为json
//		JSONObject jsonParams=JSONObject.fromObject(map2);
		JSONObject jsonParams=JSONObject.fromObject(map3);
		//装载参数
		GoodsType goodsType=new GoodsType();
		goodsType.setType_id(null);
		goodsType.setName(name);
		goodsType.setParams(jsonParams.toString());
//		goodsType.setParams(map3.toString());
		goodsType.setDisabled(0);//默认可用
		goodsType.setIs_physical(isPhysical);
		goodsType.setCreatime(null);
		goodsType.setModifytime(null);
		goodsTypeDao.save(goodsType);
		result.setStatus(0);
		result.setMsg("新增商品类型成功");
		result.setData(goodsType);
		return result;
	}

	//加载所有类型
	public Result loadAllTypes() {
		Result result=new Result();
		List<GoodsType> goodsTypes=goodsTypeDao.findAll();
		if(goodsTypes.isEmpty()){
			result.setStatus(0);
			result.setMsg("没有商品类型");
			result.setData(goodsTypes);
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载所有商品类型成功");
		result.setData(goodsTypes);
		return result;
	}

	//根据id加载
	public Result loadTypeById(int typeId) {
		Result result=new Result();
		GoodsType goodsType=goodsTypeDao.findById(typeId);
		if(goodsType==null){
			result.setStatus(1);
			result.setMsg("没有此商品类型");
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载商品类型信息成功");
		result.setData(goodsType);
		return result;
	}
	//根据id更新
	public Result updateType(int typeId,String name,String[] paramsKey,int isPhysical) {
		Result result=new Result();
		GoodsType checkGoodsType=goodsTypeDao.findById(typeId);
		if(checkGoodsType==null){
			result.setStatus(1);
			result.setMsg("没有此商品类型");
			return result;
		}
		GoodsType checkGoodsType2=goodsTypeDao.findByName(name);
		if(checkGoodsType2!=null && !name.equals(checkGoodsType.getName())){
			result.setStatus(1);
			result.setMsg("已经存在此此商品类型名称");
			return result;
		}
		//判断是否有商品关联此类型
		List<GoodsCat> gcs=goodsCatDao.findByTypeId(typeId);
		List<BriefGoods> allBGS=new ArrayList<BriefGoods>();
		for(GoodsCat gc:gcs){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("cat_id", gc.getCat_id());
			List<BriefGoods> bgs=goodsDao.dynamicFind(map);
			allBGS.addAll(bgs);
		}
		if(!allBGS.isEmpty()){
			result.setStatus(1);
			result.setMsg("有商品关联此类型，不能更新");
			return result;
		}
		GoodsType goodsType=new GoodsType();
		goodsType.setType_id(typeId);
		goodsType.setName(name);
		//构建参数
		//因为一个类型的参数有很多，所以采用map的形式
//		Map<String,Object> map2=new HashMap<String,Object>();
		Map<String,Object> map3=new HashMap<String,Object>();
		//循环向map3中增加参数名
		for(int i=0;i<=4;i++){
			if(!"".equals(paramsKey[i])){
				map3.put(paramsKey[i], "");
			}
		}
//		map2.put("参数", map3);
		//将map转为json
		JSONObject jsonParams=JSONObject.fromObject(map3);
		goodsType.setParams(jsonParams.toString());
		goodsType.setIs_physical(isPhysical);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		goodsType.setModifytime(now);
		goodsTypeDao.dynamicUpdate(goodsType);
		result.setStatus(0);
		result.setMsg("更新商品类型成功");
		return result;
	}

	//根据id删除
	public Result deleteTypeById(int typeId) {
		Result result=new Result();
		GoodsType checkGoodsType=goodsTypeDao.findById(typeId);
		if(checkGoodsType==null){
			result.setStatus(1);
			result.setMsg("没有此商品类型");
			return result;
		}
		List<TypeBrand> tbs=typeBrandDao.findByTypeId(typeId);
		//判断是否关联品牌
		if(!tbs.isEmpty()){
			result.setStatus(1);
			result.setMsg("此商品类型已经关联品牌，不能删除");
			return result;
		}
		//判断是否有选择此类型的分类
		List<GoodsCat> gcs=goodsCatDao.findByTypeId(typeId);
		if(!gcs.isEmpty()){
			result.setStatus(1);
			result.setMsg("有分类选择此类型，不能删除");
			return result;
		}
		goodsTypeDao.deleteById(typeId);
		result.setStatus(0);
		result.setMsg("删除此商品类型成功");
		return result;
	}

	//根据id更新是否可用
	public Result updateDisabled(int typeId, int disabled) {
		Result result=new Result();
		//查看是否存在此商品类型
		GoodsType checkGoodsType=goodsTypeDao.findById(typeId);
		if(checkGoodsType==null){
			result.setStatus(1);
			result.setMsg("没有此商品类型");
			return result;
		}
		//查看是否已经关联品牌
		List<TypeBrand> tbs=typeBrandDao.findByTypeId(typeId);
		if(!tbs.isEmpty()){
			result.setStatus(1);
			result.setMsg("此类型已经关联品牌");
			return result;
		}
		GoodsType goodsType=new GoodsType();
		goodsType.setType_id(typeId);
		goodsType.setDisabled(disabled);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		goodsType.setModifytime(now);
		goodsTypeDao.dynamicUpdate(goodsType);
		result.setStatus(0);
		result.setMsg("更新类型状态成功");
		return result;
	}

	//加载所有可用的类型
	public Result loadTypeByDisabled() {
		Result result=new Result();
		//可用disabled为0
		List<GoodsType> gts=goodsTypeDao.findByDisabled(0);
		//判断是否有可用的商品类型
		if(gts.isEmpty()){
			result.setStatus(1);
			result.setMsg("没有可用的商品类型");
			result.setData(gts);
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载可用的商品类型成功");
		result.setData(gts);
		return result;
	}

}
