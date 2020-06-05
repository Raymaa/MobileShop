package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.util.Result;

public interface CartService {
	//新增
	public Result addCart(int memberId,int goodsId,int goodsNum);
	//根据会员id加载（和商品表关联查询）
	public Result loadCartByMemberId(int memberId);
	//根据会员id加载选中的记录
	public Result loadChooseCartByMemberId(int memberId);
	//根据id更新
	public Result updateCart(int cartId,int goodsNum,int choose);
	//根据id更新商品数量
	public Result updateGoodsNum(int cartId,int goodsNum);
	//根据id更新状态
	public Result updateChoose(int cartId,int choose);
	//根据id删除
	public Result deleteCartById(int cartId);
}
