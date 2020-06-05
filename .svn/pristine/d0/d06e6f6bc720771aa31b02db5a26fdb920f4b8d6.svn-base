package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.util.Result;

public interface GoodsService {
	//新增商品
	public Result addGoods(String name,String sn,String brief,String description,
			double price,double cost,double mktprice,int catId,int brandId,
			double weight,String intro);
	//加载所有商品（关联查询+分页）
	public Result loadAllGoodsByPage(int current);
	//加载所有上架商品（分页）
	public Result loadAllEnableGoodsByPage(int current);
	//根据id加载商品
	public Result loadGoodsById(int goodsId);
	//根据id加载商品(关联查询)
	public Result loadGoodsByIdUnion(int goodsId);
	//根据分类id加载商品（已上架的）
	public Result loadGoodsByCatId(int catId);
	//根据品牌id加载商品（已上架的）
	public Result loadGoodsByBrandId(int brandId);
	//根据分类名称或品牌名称或商品关键字查询
	public Result searchGoods(String input);
	//根据id更新
	public Result updateGoods(int goodsId,String name,String sn,String brief,String description,
			double price,double cost,double mktprice,int mktEnable,int catId,int brandId,
			double weight,String intro,String params,String original);
	//根据id更新mkt_enable
	public Result updateEnable(int goodsId,int mktEnable);
	//根据id更新params
	public Result updateParams(int goodsId,String[] paramsValue);
	//根据id删除
	public Result deleteGoodsById(int goodsId);
}
