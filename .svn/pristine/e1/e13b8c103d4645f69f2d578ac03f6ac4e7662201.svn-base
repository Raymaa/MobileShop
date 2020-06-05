package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.entity.GoodsType;
import com.huatec.edu.mobileshop.util.Result;

public interface GoodsTypeService {
	//新增类型
	public Result addType(String name,String[] paramsKey,int isPhysical);
	//加载所有类型
	public Result loadAllTypes();
	//根据id加载
	public Result loadTypeById(int typeId);
	//根据id更新
	public Result updateType(int typeId,String name,String[] paramsKey,int isPhysical);
	//根据id删除
	public Result deleteTypeById(int typeId);
	//根据id更新是否可用
	public Result updateDisabled(int typeId,int disabled);
	//加载所有可用的类型
	public Result loadTypeByDisabled();
}
