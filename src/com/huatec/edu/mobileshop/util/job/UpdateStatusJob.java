package com.huatec.edu.mobileshop.util.job;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import com.huatec.edu.mobileshop.dao.OrderDao;
import com.huatec.edu.mobileshop.dao.OrderLogDao;
import com.huatec.edu.mobileshop.entity.Order;
import com.huatec.edu.mobileshop.entity.OrderLog;
import com.huatec.edu.mobileshop.entity.brief.BriefOrder;
/*
 * 用于自动确认收货
 * 定时检查状态为2（已发货）的订单，如果发货时间超过15天，用户还未确认收货，系统自动更新订单状态
 */
public class UpdateStatusJob {
	@Resource
	private OrderDao orderDao;
	@Resource
	private OrderLogDao orderLogDao;
	
	public void execute(){
		System.out.println("quartz执行execute方法");
		//获取当前系统时间
		Timestamp now=new Timestamp(System.currentTimeMillis());
		//查询状态为2的订单（2：发货——待收货）
		List<BriefOrder> bos=orderDao.findUnionByStatus(2);
		for(BriefOrder bo:bos){
			//获取发货的时间
			Timestamp t=bo.getBol().getTime();
			//当前时间-发货时间（毫秒值）
			Long l=now.getTime()-t.getTime();
			//将毫秒值转换为分钟
			double m=l/60000;
			//15天=15*24*60=21600分钟
			System.out.println("订单"+bo.getOrder_id()+"距离自动确认收货的时间为"+(21600.0-m)+"分钟");
			if(m>=21600){
				//更新订单状态
				Order updateOrder=new Order();
				updateOrder.setOrder_id(bo.getOrder_id());
				updateOrder.setStatus(3);//3:确认收货，完成
				orderDao.dynamicUpdate(updateOrder);
				//向日志添加一条记录
				OrderLog orderLog=new OrderLog();
				orderLog.setLog_id(null);
				orderLog.setOrder_id(bo.getOrder_id());
				orderLog.setStatus(updateOrder.getStatus());
				orderLog.setTime(now);
				orderLogDao.save(orderLog);
			}
		}
	}
}
