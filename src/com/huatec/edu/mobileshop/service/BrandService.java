package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.util.Result;

public interface BrandService {
	//新增品牌
	public Result addBrand(String name,String logo,String keywords,
			String description,String url);
	//加载所有品牌(分页)
	public Result loadAllBrandsByPage(int current);
	//根据id加载品牌
	public Result loadBrandById(int brandId);
	//根据id更新
	public Result updateBrand(int brandId,String name,String logo,String keywords,
			String description,String url);
	//根据id删除
	public Result deleteBrandById(int brandId);
	//根据id更新是否可用
	public Result updateDisabled(int brandId,int disabled);
	//加载所有可用的品牌
	public Result loadBrandByDisabled();
}
