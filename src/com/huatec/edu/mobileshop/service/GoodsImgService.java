package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.util.Result;

public interface GoodsImgService {
	//新增商品图片引用
	public Result addImg(int goodsId,int isdefault,String img,String url);
	//根据id更新
	public Result updateImg(int imgId,String img,String url);
	//根据id删除
	public Result deleteImgById(int imgId,String url);
}
