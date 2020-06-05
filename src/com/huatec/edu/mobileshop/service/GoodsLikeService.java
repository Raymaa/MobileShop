package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.util.Result;

public interface GoodsLikeService {
	//新增商品收藏信息
	public Result add(int goodsId,int memberId);
	//根据会员id加载收藏的商品
	public Result loadByMemberId(int memberId);
	//根据id删除
	public Result deleteById(int likeId);
}
