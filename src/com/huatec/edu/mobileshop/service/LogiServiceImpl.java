package com.huatec.edu.mobileshop.service;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatec.edu.mobileshop.dao.LogiDao;
import com.huatec.edu.mobileshop.dao.OrderDao;
import com.huatec.edu.mobileshop.dao.OrderLogDao;
import com.huatec.edu.mobileshop.entity.Logi;
import com.huatec.edu.mobileshop.entity.Order;
import com.huatec.edu.mobileshop.entity.OrderLog;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class LogiServiceImpl implements LogiService {
	@Resource
	private LogiDao logiDao;
	@Resource
	private OrderDao orderDao;
	@Resource
	private OrderLogDao orderLogDao;
	
	//更新物流状态（发货,更新状态）
	public Result updateLogi(int orderId, int shipId, String sn, String sender) {
		Result result=new Result();
		Order order=orderDao.findById(orderId);
		if(order==null){
			result.setStatus(1);
			result.setMsg("不存在此订单");
			return result;
		}
		if(order.getStatus()!=1){
			result.setStatus(1);
			result.setMsg("不是待发货状态");
			return result;
		}
		//更新物流信息
		int logiId=order.getLogi_id();
		Logi logi=new Logi();
		logi.setLogi_id(logiId);
		logi.setShip_id(shipId);
		logi.setSn(sn);
		logi.setSender(sender);
		logi.setStatus(1);//1:发货状态
		Timestamp now=new Timestamp(System.currentTimeMillis());
		logi.setModifytime(now);//发货时间
		logiDao.dynamicUpdate(logi);
		//更新订单状态
		Order updateOrder=new Order();
		updateOrder.setOrder_id(orderId);
		updateOrder.setStatus(2);//2:发货完成，待收货
		orderDao.dynamicUpdate(updateOrder);
		//向日志添加一条记录
		OrderLog orderLog=new OrderLog();
		orderLog.setLog_id(null);
		orderLog.setOrder_id(orderId);
		orderLog.setStatus(updateOrder.getStatus());
		orderLog.setTime(now);
		orderLogDao.save(orderLog);
		result.setStatus(0);
		result.setMsg("发货完成");
		return result;
	}

	//更新物流状态（确认收货）
	public Result updateLogiStatus(int orderId) {
		Result result=new Result();
		Order order=orderDao.findById(orderId);
		if(order==null){
			result.setStatus(1);
			result.setMsg("不存在此订单");
			return result;
		}
		if(order.getStatus()!=2){
			result.setStatus(1);
			result.setMsg("不是待收货状态");
			return result;
		}
		//更新物流状态
		int logiId=order.getLogi_id();
		Logi logi=new Logi();
		logi.setLogi_id(logiId);
		logi.setStatus(2);//2：确认收货
		logiDao.dynamicUpdate(logi);
		//更新订单状态
		Order updateOrder=new Order();
		updateOrder.setOrder_id(orderId);
		updateOrder.setStatus(3);//3:确认收货，完成
		orderDao.dynamicUpdate(updateOrder);
		//向日志添加一条记录
		OrderLog orderLog=new OrderLog();
		orderLog.setLog_id(null);
		orderLog.setOrder_id(orderId);
		orderLog.setStatus(updateOrder.getStatus());
		Timestamp now=new Timestamp(System.currentTimeMillis());
		orderLog.setTime(now);
		orderLogDao.save(orderLog);
		result.setStatus(0);
		result.setMsg("确认收货完成");
		return result;
	}

}
