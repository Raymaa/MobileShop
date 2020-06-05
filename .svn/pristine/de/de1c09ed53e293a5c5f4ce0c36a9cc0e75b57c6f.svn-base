package com.huatec.edu.mobileshop.service;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatec.edu.mobileshop.dao.OrderDao;
import com.huatec.edu.mobileshop.dao.OrderLogDao;
import com.huatec.edu.mobileshop.dao.PaymentDao;
import com.huatec.edu.mobileshop.entity.Order;
import com.huatec.edu.mobileshop.entity.OrderLog;
import com.huatec.edu.mobileshop.entity.Payment;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class PaymentServiceImpl implements PaymentService {
	@Resource
	private PaymentDao paymentDao;
	@Resource
	private OrderDao orderDao;
	@Resource
	private OrderLogDao orderLogDao;
	//更新支付状态（付款，改变状态）
	public Result updatePayment(int orderId) {
		Result result=new Result();
		Order order=orderDao.findById(orderId);
		if(order==null){
			result.setStatus(1);
			result.setMsg("不存在此订单");
			return result;
		}
		if(order.getStatus()!=0){
			result.setStatus(1);
			result.setMsg("不是待付款状态");
			return result;
		}
		int paymentId=order.getPayment_id();
		//根据支付类型调用相应的接口进行付款
		System.out.println("付款中......");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("付款成功");
		//更新支付状态
		Payment payment=new Payment();
		payment.setPayment_id(paymentId);
		payment.setStatus(1);//1:支付成功
		Timestamp now=new Timestamp(System.currentTimeMillis());
		payment.setPaytime(now);
		paymentDao.dynamicUpdate(payment);
		//更新订单状态
		Order updateOrder=new Order();
		updateOrder.setOrder_id(orderId);
		updateOrder.setStatus(1);//1:付款完成，待发货
		orderDao.dynamicUpdate(updateOrder);
		//向日志添加一条记录
		OrderLog orderLog=new OrderLog();
		orderLog.setLog_id(null);
		orderLog.setOrder_id(orderId);
		orderLog.setStatus(updateOrder.getStatus());
		orderLog.setTime(now);
		orderLogDao.save(orderLog);
		result.setStatus(0);
		result.setMsg("支付完成");
		return result;
	}

}
