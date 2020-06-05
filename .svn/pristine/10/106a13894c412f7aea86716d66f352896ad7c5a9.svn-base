package com.huatec.edu.mobileshop.dao;

import java.util.List;
import java.util.Map;

import com.huatec.edu.mobileshop.entity.OrderGoods;

public interface OrderGoodsDao {
	public int save(OrderGoods orderGoods);
	public List<OrderGoods> findAll();
	public int deleteById(int id);
	public OrderGoods findById(int id);
//	public List<OrderGoods> findUnionByMemberId(int memberId);
	public OrderGoods findRepeat(Map map);
	public List<OrderGoods> findUnionByOrderId(int orderId);
}
