package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.util.Result;

public interface TagService {
	//新增标签
	public Result addTag(String name,int type,int count,int team);
	//加载所有标签（分页）
	public Result loadAllTagsByPage(int current);
	//加载所有商品标签
	public Result loadAllGoodsTag();
	//加载所有品牌标签
	public Result loadAllBrandTag();
	//根据分组加载标签下的商品
	public Result loadAllGoodsByTeam(int team);
	//根据分组加载标签下的品牌
	public Result loadAllBrandByTeam(int team);
	//根据id加载
	public Result loadTagById(int tagId);
	//根据id更新
	public Result updateTag(int tagId,String name,int type,int count,int sort,int team);
	//根据id删除
	public Result deleteTagById(int tagId);
}
