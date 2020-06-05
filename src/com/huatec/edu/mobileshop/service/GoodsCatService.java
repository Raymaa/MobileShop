package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.util.Result;

public interface GoodsCatService {
	//新增分类
	public Result addCat(String name,int parentId,int typeId);
	//加载顶级分类（和类型表关联查询）
	public Result loadTopCat();
	//根据父id加载二级分类（和类型表关联查询）
	public Result loadCatByParentId(int parentId);
	//加载”可显示到列表“的顶级分类
	public Result loadShowTopCat();
	//根据父id加载”可显示到列表“的二级分类
	public Result loadShowCatByParentId(int parentId);
	//根据id加载分类
	public Result loadCatById(int catId);
	//根据id加载分类（关联查询）
	public Result loadUnionCatById(int catId);
	//根据id更新
	public Result updateCat(int catId,String name,int sort,int typeId,
			int list_show,String image);
	//根据id更新image（设置图片）
	public Result updateImage(int catId,String img,String url);
	//根据id删除
	public Result deleteCatById(int catId);
	//根据id更新商品数量 flag=0,数量+1，flag=1,数量-1
	public Result updateGoodsCount(int catId,int flag);
	
}
