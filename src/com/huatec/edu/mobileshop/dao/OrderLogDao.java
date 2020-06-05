package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.OrderLog;
import com.huatec.edu.mobileshop.entity.brief.BriefOrderLog;

public interface OrderLogDao {
	public int save(OrderLog orderLog);
	public List<OrderLog> findAll();
	public OrderLog findById(int log_id);
	public List<BriefOrderLog> findByOrderId(int order_id);
}
