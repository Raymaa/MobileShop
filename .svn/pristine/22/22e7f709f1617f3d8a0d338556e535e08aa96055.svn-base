package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.OrderDao;
import com.huatec.edu.mobileshop.entity.Order;
import com.huatec.edu.mobileshop.entity.brief.BriefOrder;

public class TestOrderDao {
	//获取OrderDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	OrderDao orderDao=ac.getBean("orderDao",OrderDao.class);
	
	@Test
	public void test8(){
		Map<String,Object> map=new HashMap<String,Object>();
		int current=1;
		int pageSize=5;
		int begin=(current-1)*pageSize;
		map.put("begin", begin);
		map.put("pageSize", pageSize);
		map.put("status", 4);
		List<Order> os=orderDao.dynamicFindUnion(map);
		for(Order o:os){
			System.out.println(o);
		}
	}
	@Test
	public void test7(){
		List<BriefOrder> bos=orderDao.findUnionByStatus(4);
		for(BriefOrder bo:bos){
			System.out.println(bo);
			Timestamp t=bo.getBol().getTime();
			Timestamp now=new Timestamp(System.currentTimeMillis());
			Long l=now.getTime()-t.getTime();
			System.out.println(l);
			//15天=15*24*60=21600分钟
			int m=1000*60;
			System.out.println(l/m);
		}
	}
	@Test
	public void test6(){
		List<Order> os=orderDao.findUnionByMemberId(16);
		for(Order o:os){
			System.out.println(o);
		}
	}
	@Test
	public void test5(){
		Order order=new Order();
		order.setOrder_id(2);
		order.setTotal_amount(28.88);
		orderDao.dynamicUpdate(order);
	}
	@Test
	public void test4(){
		Order o=orderDao.findById(2);
		System.out.println(o);
	}
	@Test
	public void test3(){
		orderDao.deleteById(1);
	}
	@Test
	public void test2(){
		List<Order> os=orderDao.findAll();
		for(Order o:os){
			System.out.println(o);
		}
	}
	@Test
	public void test1(){
		Order order=new Order();
		order.setOrder_id(null);
		order.setSn(UUID.randomUUID().toString().replaceAll("-", ""));
		order.setMember_id(5);
		order.setStatus(0);
		order.setPayment_id(0);
		order.setLogi_id(0);
		order.setTotal_amount(20.0);
		order.setAddress_id(3);
		order.setCreatime(null);
		order.setModifytime(null);
		orderDao.save(order);
	}
}
