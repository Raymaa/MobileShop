package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.util.Result;

public interface OrderService {
	//创建订单
	public Result addOrder(int memberId,int addressId,int paytypeId,double carriage);
	//根据id加载
	public Result loadOrderById(int orderId);
	//根据会员id加载（“我的订单”页面，订单表、订单商品表、商品表关联查询）
	public Result loadOrderByMemberId(int memberId);
	//加载所有订单（分页）
	public Result loadAllOrderByPage(int current);
	//根据状态加载订单（待付款、待发货,分页）
	public Result loadOrderByStatus(int status,int current);
	//更新订单状态（取消订单）
	public Result updateOrderStatus(int orderId);
}
