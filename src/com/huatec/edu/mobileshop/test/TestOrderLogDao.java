package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.OrderLogDao;
import com.huatec.edu.mobileshop.entity.OrderLog;
import com.huatec.edu.mobileshop.entity.brief.BriefOrderLog;

public class TestOrderLogDao {
	//获取OrderLogDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	OrderLogDao orderLogDao=ac.getBean("orderLogDao",OrderLogDao.class);
	
	@Test
	public void test4(){
		List<BriefOrderLog> bols=orderLogDao.findByOrderId(3);
		for(BriefOrderLog bol:bols){
			System.out.println(bol);
		}
	}
	@Test
	public void test3(){
		OrderLog ol=orderLogDao.findById(1);
		System.out.println(ol);
	}
	@Test
	public void test2(){
		List<OrderLog> ols=orderLogDao.findAll();
		for(OrderLog ol:ols){
			System.out.println(ol);
		}
	}
	@Test
	public void test1(){
		OrderLog ol=new OrderLog();
		ol.setLog_id(null);
		ol.setOrder_id(16);
		ol.setStatus(0);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		ol.setTime(now);
		orderLogDao.save(ol);
	}
}
