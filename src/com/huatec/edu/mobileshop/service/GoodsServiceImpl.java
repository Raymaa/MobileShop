package com.huatec.edu.mobileshop.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huatec.edu.mobileshop.dao.BrandDao;
import com.huatec.edu.mobileshop.dao.CartDao;
import com.huatec.edu.mobileshop.dao.GoodStoreDao;
import com.huatec.edu.mobileshop.dao.GoodsCatDao;
import com.huatec.edu.mobileshop.dao.GoodsDao;
import com.huatec.edu.mobileshop.dao.GoodsImgDao;
import com.huatec.edu.mobileshop.dao.GoodsTypeDao;
import com.huatec.edu.mobileshop.entity.Brand;
import com.huatec.edu.mobileshop.entity.Cart;
import com.huatec.edu.mobileshop.entity.Goods;
import com.huatec.edu.mobileshop.entity.GoodsCat;
import com.huatec.edu.mobileshop.entity.GoodsType;
import com.huatec.edu.mobileshop.entity.brief.BriefGoods;
import com.huatec.edu.mobileshop.util.Page;
import com.huatec.edu.mobileshop.util.Result;

import net.sf.json.JSONObject;
@Service
public class GoodsServiceImpl implements GoodsService {
	@Resource
	private GoodsDao goodsDao;
	@Resource
	private GoodsCatDao goodsCatDao;
	@Resource
	private GoodsTypeDao goodsTypeDao;
	@Resource
	private BrandDao brandDao;
	@Resource
	private GoodStoreDao goodStoreDao;
	@Resource
	private GoodsImgDao GoodsImgDao;
	@Resource
	private GoodsCatService goodsCatService;
	@Resource
	private CartDao cartDao;
	
//	protected final Logger logger = Logger.getLogger(getClass());
	
	//新增商品
	public Result addGoods(String name, String sn, String brief, String description, 
			double price, double cost,double mktprice, int catId, int brandId, 
			double weight, String intro) {
		Result result=new Result();
		BriefGoods bg=goodsDao.findByName(name);
		if(bg!=null){
			result.setStatus(1);
			result.setMsg("此商品名称已经存在");
			return result;
		}
		GoodsCat gc=goodsCatDao.findById(catId);
		if(gc==null){
			result.setStatus(1);
			result.setMsg("没有此分类");
			return result;
		}
		if(gc.getList_show()!=0){
			result.setStatus(1);
			result.setMsg("此分类不可用");
			return result;
		}
		if(gc.getParent_id()==0){
			result.setStatus(1);
			result.setMsg("不能在顶级分类中添加商品");
			return result;
		}
		
		Brand brand=brandDao.findById(brandId);
		if(brand==null){
			result.setStatus(1);
			result.setMsg("没有此品牌");
			return result;
		}
		if(brand.getDisabled()!=0){
			result.setStatus(1);
			result.setMsg("此品牌不可用");
			return result;
		}
		Goods goods=new Goods();
		goods.setGoods_id(null);
		goods.setName(name);//名称
		goods.setSn(sn);//货号
		goods.setBrief(brief);//简介
		goods.setDescription(description);//详细描述
		goods.setPrice(price);//销售价
		goods.setCost(cost);//成本价
		goods.setMktprice(mktprice);//市场价
		goods.setMkt_enable(0);//默认上架
		goods.setCat_id(catId);//分类id
		goods.setBrand_id(brandId);//品牌id
		goods.setWeight(weight);//重量
		goods.setIntro(intro);//详情图片
		int typeId=gc.getType_id();
		GoodsType gt=goodsTypeDao.findById(typeId);
		if(gt!=null){
			goods.setParams(gt.getParams());//参数
		}else{
			goods.setParams("");//参数
		}
		goods.setCreatime(null);//创建时间
		goods.setLast_modify(null);//最后修改时间
		goods.setView_count(0);//浏览次数
		goods.setBuy_count(0);//购买次数
		//默认没有主图相关图片
		goods.setThumbnail("");//缩略图
		goods.setBig("");//大图
		goods.setSmall("");//小图
		goods.setOriginal("");//原图
		goodsDao.save(goods);
		//更新分类中的商品数量（+1）
		goodsCatService.updateGoodsCount(catId,0);
		result.setStatus(0);
		result.setMsg("新建商品成功");
		result.setData(goods);
		return result;
	}
	//加载所有商品（关联查询+分页）
	public Result loadAllGoodsByPage(int current) {
		Result result=new Result();
		Page page=new Page();
		page.setCurrent(current);
		page.setPageSize(10);
		List<BriefGoods> bgs=goodsDao.findUnionByPage(page);
		if(bgs.isEmpty()){
			result.setStatus(1);
			result.setMsg("此页没有商品");
			result.setData(bgs);
			return result;
		}
		result.setStatus(0);
		result.setMsg("查询商品成功");
		result.setData(bgs);
		return result;
	}
	//加载所有上架商品（分页）
	public Result loadAllEnableGoodsByPage(int current) {
		Result result=new Result();
		Page page=new Page();
		page.setCurrent(current);
		page.setPageSize(10);
		List<BriefGoods> bgs=goodsDao.findAllEnableByPage(page);
		if(bgs.isEmpty()){
			result.setStatus(1);
			result.setMsg("此页没有商品");
			result.setData(bgs);
			return result;
		}
		result.setStatus(0);
		result.setMsg("查询可用的商品成功");
		result.setData(bgs);
		return result;
	}
	//根据id加载商品
	public Result loadGoodsById(int goodsId) {
		Result result=new Result();
		Goods goods=goodsDao.findById(goodsId);
		if(goods==null){
			result.setStatus(1);
			result.setMsg("不存在此商品");
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载商品信息成功");
		result.setData(goods);
		return result;
	}
	//根据id加载商品(关联查询)
	public Result loadGoodsByIdUnion(int goodsId) {
		Result result=new Result();
		Goods checkGoods=goodsDao.findById(goodsId);
		if(checkGoods==null){
			result.setStatus(1);
			result.setMsg("不存在此商品");
			return result;
		}
		//更新浏览次数
		int viewCount=checkGoods.getView_count();
		viewCount++;
		Goods updateGoods=new Goods();
		updateGoods.setGoods_id(checkGoods.getGoods_id());
		updateGoods.setView_count(viewCount);
		goodsDao.dynamicUpdate(updateGoods);
		//关联查询
		Goods goods=goodsDao.findUnionById(goodsId);
		result.setStatus(0);
		result.setMsg("加载商品信息成功");
		result.setData(goods);
		return result;
	}
	//根据分类id查询商品（已上架的）
	public Result loadGoodsByCatId(int catId) {
		Result result=new Result();
		GoodsCat gc=goodsCatDao.findById(catId);
		if(gc==null){
			result.setStatus(1);
			result.setMsg("没有此分类");
			return result;
		}
		if(gc.getList_show()!=0){
			result.setStatus(1);
			result.setMsg("此分类不可用");
			return result;
		}
		//顶级分类
		if(gc.getParent_id()==0){
			//查询可显示的子分类
			GoodsCat gc2=new GoodsCat();
			gc2.setParent_id(catId);
			gc2.setList_show(0);
			List<GoodsCat> gcs=goodsCatDao.dynamicFind(gc2);
			if(gcs.isEmpty()){
				result.setStatus(1);
				result.setMsg("此分类下没有商品");
				return result;
			}
			List<BriefGoods> allBGS=new ArrayList<BriefGoods>();
			//循环查询子分类下的商品
			for(GoodsCat goodsCat:gcs){
				int subCatId=goodsCat.getCat_id();
				Map<String,Object> map1=new HashMap<String,Object>();
				map1.put("cat_id", subCatId);
				map1.put("mkt_enable", 0);
				List<BriefGoods> bgs=goodsDao.dynamicFind(map1);
				allBGS.addAll(bgs);
			}
			if(allBGS.isEmpty()){
				result.setStatus(1);
				result.setMsg("此分类下没有商品");
				result.setData(allBGS);
				return result;
			}
			result.setStatus(0);
			result.setMsg("查询商品成功");
			result.setData(allBGS);
			return result;
		}else{
			//二级分类
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("cat_id", catId);
			map.put("mkt_enable", 0);
			List<BriefGoods> bgs=goodsDao.dynamicFind(map);
			if(bgs.isEmpty()){
				result.setStatus(1);
				result.setMsg("此分类下没有商品");
				result.setData(bgs);
				return result;
			}
			result.setStatus(0);
			result.setMsg("查询商品成功");
			result.setData(bgs);
			return result;
		}
	}
	
	//根据品牌id加载商品（已上架的）
	public Result loadGoodsByBrandId(int brandId) {
		Result result=new Result();
		Brand brand=brandDao.findById(brandId);
		if(brand==null){
			result.setStatus(1);
			result.setMsg("没有此品牌");
			return result;
		}
		if(brand.getDisabled()!=0){
			result.setStatus(1);
			result.setMsg("此品牌不可用");
			return result;
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("brand_id", brandId);
		map.put("mkt_enable", 0);
		List<BriefGoods> bgs=goodsDao.dynamicFind(map);
		if(bgs.isEmpty()){
			result.setStatus(1);
			result.setMsg("没有商品关联此品牌");
			result.setData(bgs);
			return result;
		}
		result.setStatus(0);
		result.setMsg("查询商品成功");
		result.setData(bgs);
		return result;
	}
	//根据分类名称或品牌名称或商品关键字查询（上架商品）
	public Result searchGoods(String input) {
		Result result=new Result();
		//判断input是否为空
		if("".equals(input)){
			result.setStatus(1);
			result.setMsg("请输入您搜索的关键字");
			return result;
		}
		List<BriefGoods> allBGS=new ArrayList<BriefGoods>();
		
		//根据商品关键字查询
		String likeName="%"+input.trim()+"%";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", likeName);
		map.put("mkt_enable", 0);
		List<BriefGoods> bgs=goodsDao.dynamicFind(map);
		allBGS.addAll(bgs);
		if(!bgs.isEmpty()){
			result.setStatus(0);
			result.setMsg("根据商品关键字查询商品成功");
			result.setData(allBGS);
			return result;
		}
		
		//根据品牌名称查询
		Brand brand=brandDao.findByName(input);
		if(brand!=null){
			int brandId=brand.getBrand_id();
			Map<String,Object> map1=new HashMap<String,Object>();
			map1.put("brand_id", brandId);
			map1.put("mkt_enable", 0);
			List<BriefGoods> bgs1=goodsDao.dynamicFind(map1);
			allBGS.addAll(bgs1);
			if(!bgs1.isEmpty()){
				result.setStatus(0);
				result.setMsg("根据品牌查询商品成功");
				result.setData(allBGS);
				return result;
			}
			
		}
		//根据分类名称查询
		GoodsCat goodsCat=goodsCatDao.findByName(input);
		if(goodsCat!=null){
			//顶级分类
			if(goodsCat.getParent_id()==0){
				GoodsCat gc1=new GoodsCat();
				gc1.setParent_id(goodsCat.getCat_id());
				gc1.setList_show(0);
				List<GoodsCat> gcs=goodsCatDao.dynamicFind(gc1);
				//顶级分类下没有二级分类
				if(gcs.isEmpty()){
					result.setStatus(1);
					result.setMsg("此分类下没有商品");
					return result;
				}
				for(GoodsCat gc:gcs){
					int subCatId=gc.getCat_id();
					Map<String,Object> map2=new HashMap<String,Object>();
					map2.put("cat_id", subCatId);
					map2.put("mkt_enable", 0);
					List<BriefGoods> bgs2=goodsDao.dynamicFind(map2);
					allBGS.addAll(bgs);
				}
				if(!allBGS.isEmpty()){
					result.setStatus(0);
					result.setMsg("根据分类查询商品成功");
					result.setData(allBGS);
					return result;
				}
				
			}else{
				//二级分类
				Map<String,Object> map3=new HashMap<String,Object>();
				map3.put("cat_id", goodsCat.getCat_id());
				map3.put("mkt_enable", 0);
				List<BriefGoods> bgs3=goodsDao.dynamicFind(map3);
				allBGS.addAll(bgs3);
				if(!bgs3.isEmpty()){
					result.setStatus(0);
					result.setMsg("根据分类查询商品成功");
					result.setData(allBGS);
					return result;
				}
				
			}
		}
		result.setStatus(1);
		result.setMsg("没有符合条件的商品");
		return result;
	}
	
	//根据分类名称或品牌名称或商品关键字查询（全部商品）
	public Result searchGoods2(String input) {
		Result result=new Result();
		//判断input是否为空
		if("".equals(input)){
			result.setStatus(1);
			result.setMsg("请输入您搜索的关键字");
			return result;
		}
		List<BriefGoods> allBGS=new ArrayList<BriefGoods>();
		
		//根据商品关键字查询
		String likeName="%"+input.trim()+"%";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", likeName);
//		map.put("mkt_enable", 0);
		List<BriefGoods> bgs=goodsDao.dynamicFind(map);
		allBGS.addAll(bgs);
		if(!bgs.isEmpty()){
			result.setStatus(0);
			result.setMsg("根据商品关键字查询商品成功");
			result.setData(allBGS);
			return result;
		}
		
		//根据品牌名称查询
		Brand brand=brandDao.findByName(input);
		if(brand!=null){
			int brandId=brand.getBrand_id();
			Map<String,Object> map1=new HashMap<String,Object>();
			map1.put("brand_id", brandId);
//			map1.put("mkt_enable", 0);
			List<BriefGoods> bgs1=goodsDao.dynamicFind(map1);
			allBGS.addAll(bgs1);
			if(!bgs1.isEmpty()){
				result.setStatus(0);
				result.setMsg("根据品牌查询商品成功");
				result.setData(allBGS);
				return result;
			}
			
		}
		//根据分类名称查询
		GoodsCat goodsCat=goodsCatDao.findByName(input);
		if(goodsCat!=null){
			//顶级分类
			if(goodsCat.getParent_id()==0){
				GoodsCat gc1=new GoodsCat();
				gc1.setParent_id(goodsCat.getCat_id());
				gc1.setList_show(0);
				List<GoodsCat> gcs=goodsCatDao.dynamicFind(gc1);
				//顶级分类下没有二级分类
				if(gcs.isEmpty()){
					result.setStatus(1);
					result.setMsg("此分类下没有商品");
					return result;
				}
				for(GoodsCat gc:gcs){
					int subCatId=gc.getCat_id();
					Map<String,Object> map2=new HashMap<String,Object>();
					map2.put("cat_id", subCatId);
//					map2.put("mkt_enable", 0);
					List<BriefGoods> bgs2=goodsDao.dynamicFind(map2);
					allBGS.addAll(bgs);
				}
				if(!allBGS.isEmpty()){
					result.setStatus(0);
					result.setMsg("根据分类查询商品成功");
					result.setData(allBGS);
					return result;
				}
				
			}else{
				//二级分类
				Map<String,Object> map3=new HashMap<String,Object>();
				map3.put("cat_id", goodsCat.getCat_id());
//				map3.put("mkt_enable", 0);
				List<BriefGoods> bgs3=goodsDao.dynamicFind(map3);
				allBGS.addAll(bgs3);
				if(!bgs3.isEmpty()){
					result.setStatus(0);
					result.setMsg("根据分类查询商品成功");
					result.setData(allBGS);
					return result;
				}
				
			}
		}
		result.setStatus(1);
		result.setMsg("没有符合条件的商品");
		return result;
	}
	
	
	//根据id更新
	public Result updateGoods(int goodsId,String name, String sn, String brief, 
			String description, double price, double cost,double mktprice, 
			int mktEnable,int catId, int brandId, double weight, String intro) {
		Result result=new Result();
		BriefGoods checkGoods1=goodsDao.findByName(name);
		Goods checkGoods2=goodsDao.findById(goodsId);
		if(checkGoods1!=null && !name.equals(checkGoods2.getName())){
			result.setStatus(1);
			result.setMsg("已经存在此商品名称");
			return result;
		}
		Goods goods=new Goods();
		goods.setGoods_id(goodsId);
		goods.setName(name);
		goods.setSn(sn);
		goods.setBrief(brief);
		goods.setDescription(description);
		goods.setPrice(price);
		goods.setCost(cost);
		goods.setMktprice(mktprice);
		goods.setMkt_enable(mktEnable);
		goods.setCat_id(catId);
		goods.setBrand_id(brandId);
		goods.setWeight(weight);
		goods.setIntro(intro);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		goods.setLast_modify(now);
		//修改图片尺寸
		//如果price改变，更新购物车中的商品金额
		if(checkGoods2.getPrice()!=price){
			Cart findCart=new Cart();
			findCart.setGoods_id(goodsId);
			List<Cart> carts=cartDao.dynamicFind(findCart);
			if(!carts.isEmpty()){
				for(Cart cart:carts){
					Cart updateCart=new Cart();
					updateCart.setCart_id(cart.getCart_id());
					updateCart.setAmount(price*cart.getGoods_num());
					cartDao.dynamicUpdate(updateCart);
				}
			}
		}
		goodsDao.dynamicUpdate(goods);
		result.setStatus(0);
		result.setMsg("更新商品信息成功");
		return result;
	}
	//根据id更新mkt_enable
	public Result updateEnable(int goodsId, int mktEnable) {
		Result result=new Result();
		Goods checkGoods=goodsDao.findById(goodsId);
		if(checkGoods==null){
			result.setStatus(1);
			result.setMsg("不存在此商品");
			return result;
		}
		Goods goods=new Goods();
		goods.setGoods_id(goodsId);
		goods.setMkt_enable(mktEnable);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		goods.setLast_modify(now);
		goodsDao.dynamicUpdate(goods);
		result.setStatus(0);
		result.setMsg("更新商品状态成功");
		return result;
	}
	//根据id更新params
	public Result updateParams(int goodsId,String[] paramsValue) {
		Result result=new Result();
		Goods checkGoods=goodsDao.findById(goodsId);
		if(checkGoods==null){
			result.setStatus(1);
			result.setMsg("不存在此商品");
			return result;
		}
		GoodsCat gc=goodsCatDao.findById(checkGoods.getCat_id());
		GoodsType gt=goodsTypeDao.findById(gc.getType_id());
		//将参数转json
		JSONObject jParams1=JSONObject.fromObject(gt.getParams());
		//将json转为map
		//参数由俩层Map组成
		//{'参数':{'产地':'','净含量':'','保质期':'','口味':''}}
		//outMap，外层Map
//		Map outMap=jParams1;
		//将内层参数转json
//		JSONObject jParams2=JSONObject.fromObject(outMap.get("params"));
		//inMap，内层Map
//		Map inMap=jParams2;
		Map inMap=jParams1;
		//获取内层Map的key
		Set<String> keySet=inMap.keySet();
		Iterator it=keySet.iterator();
		//将参数值循环加入inMap中
		for(int i=0;i<=4;i++){
			if(it.hasNext()){
				inMap.put(it.next(), paramsValue[i]);
			}
		}
		//将inMap放入outMap中
//		outMap.put("params", inMap);
		Goods goods=new Goods();
		goods.setGoods_id(goodsId);
//		goods.setParams(outMap.toString());
		goods.setParams(inMap.toString());
		goodsDao.dynamicUpdate(goods);
		result.setStatus(0);
		result.setMsg("更新商品参数成功");
		return result;
	}

	//根据id删除
	public Result deleteGoodsById(int goodsId) {
		Result result=new Result();
		Goods goods=goodsDao.findById(goodsId);
		if(goods==null){
			result.setStatus(1);
			result.setMsg("此商品不存在");
			return result;
		}
		int catId=goods.getCat_id();
		goodsDao.deleteById(goodsId);
		//更新分类中的商品数量（-1）
		goodsCatService.updateGoodsCount(catId, 1);
		result.setStatus(0);
		result.setMsg("删除商品成功");
		return result;
	}
	public Result countPage1() {
		Result result=new Result();
		int num=goodsDao.count1();//记录总数
		System.out.println("记录总数:"+num);
		int count=num%10==0?num/10:num/10+1;
		result.setStatus(0);
		result.setMsg("查询页数成功");
		result.setData(count);
		return result;
	}
	public Result countPage2() {
		Result result=new Result();
		int num=goodsDao.count2();//记录总数
		System.out.println("记录总数:"+num);
		int count=num%10==0?num/10:num/10+1;
		result.setStatus(0);
		result.setMsg("查询页数成功");
		result.setData(count);
		return result;
	}
	
}
