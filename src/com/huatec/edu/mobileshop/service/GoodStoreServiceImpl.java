package com.huatec.edu.mobileshop.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatec.edu.mobileshop.dao.GoodStoreDao;
import com.huatec.edu.mobileshop.dao.GoodsDao;
import com.huatec.edu.mobileshop.entity.GoodStore;
import com.huatec.edu.mobileshop.entity.Goods;
import com.huatec.edu.mobileshop.util.Page;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class GoodStoreServiceImpl implements GoodStoreService {
	@Resource
	private GoodStoreDao goodStoreDao;
	@Resource
	private GoodsDao goodsDao;
	//新增商品库存
	public Result addStore(int goodsId, int store) {
		Result result=new Result();
		Goods goods=goodsDao.findById(goodsId);
		//判断是否存在此商品
		if(goods==null){
			result.setStatus(1);
			result.setMsg("不存在此商品");
			return result;
		}
		//判断此商品是否已下架
		if(goods.getMkt_enable()!=0){
			result.setStatus(1);
			result.setMsg("商品已下架");
			return result;
		}
		//判断是否已经存在此商品的库存
		GoodStore checkGS=goodStoreDao.findByGoodsId(goodsId);
		if(checkGS!=null){
			result.setStatus(1);
			result.setMsg("已经存在此商品的库存");
			return result;
		}
		GoodStore goodStore=new GoodStore();
		goodStore.setStore_id(null);
		goodStore.setGoods_id(goodsId);
		goodStore.setStore(store);
		goodStore.setEnable_store(store);
		goodStore.setOperate_type(0);//0:入库，1：出库
		goodStore.setIntime(null);
		goodStore.setOutime(null);
		goodStoreDao.save(goodStore);
		result.setStatus(0);
		result.setMsg("新增商品库存成功");
		result.setData(goodStore);
		return result;
	}
	//查询所有库存（关联查询+分页）
	public Result loadAllStore(int current) {
		Result result=new Result();
		Page page=new Page();
		page.setCurrent(current);
		page.setPageSize(10);
		List<GoodStore> gss=goodStoreDao.findUnionByPage(page);
		if(gss.isEmpty()){
			result.setStatus(1);
			result.setMsg("此页没有商品库存");
			result.setData(gss);
			return result;
		}
		result.setStatus(0);
		result.setMsg("查询商品库存成功");
		result.setData(gss);
		return result;
	}
	//根据id更新库存
	public Result updateStore(int storeId, int store) {
		Result result=new Result();
		GoodStore checkGS=goodStoreDao.findById(storeId);
		if(checkGS==null){
			result.setStatus(1);
			result.setMsg("没有此库存");
			return result;
		}
		int oldStore=checkGS.getStore();
		int updateCount=store-oldStore;
		//可用库存
		int enableStore=checkGS.getEnable_store()+updateCount;
		GoodStore goodStore=new GoodStore();
		goodStore.setStore_id(storeId);
		goodStore.setStore(store);
		if(enableStore<0){
			goodStore.setEnable_store(0);
		}else{
			goodStore.setEnable_store(enableStore);
		}
		goodStore.setOperate_type(0);//更新默认是入库
		Timestamp now=new Timestamp(System.currentTimeMillis());
		goodStore.setIntime(now);
		goodStoreDao.dynamicUpdate(goodStore);
		result.setStatus(0);
		result.setMsg("更新库存成功");
		return result;
	}
	//根据id删除
	public Result deleteStoreById(int storeId) {
		Result result=new Result();
		GoodStore checkGS=goodStoreDao.findById(storeId);
		if(checkGS==null){
			result.setStatus(1);
			result.setMsg("没有此库存");
			return result;
		}
		/*Goods goods=goodsDao.findById(checkGS.getGoods_id());
		if(goods.getMkt_enable()==0){
			result.setStatus(1);
			result.setMsg("此商品正在销售");
			return result;
		}*/
		goodStoreDao.deleteById(storeId);
		result.setStatus(0);
		result.setMsg("删除商品库存成功");
		return result;
	}

}
