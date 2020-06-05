package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.Order;
import com.huatec.edu.mobileshop.entity.select.OrderResult;
import com.huatec.edu.mobileshop.service.OrderService;
import com.huatec.edu.mobileshop.util.Result;

public class TestOrderService {
	//获取OrderService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	OrderService orderService=ac.getBean("orderServiceImpl",OrderService.class);
	
	@Test
	public void test6(){
		Result result=orderService.loadOrderByStatus(4, 1);
		System.out.println(result.getMsg());
		List<Order> os=(List<Order>) result.getData();
		for(Order o:os){
			System.out.println(o);
		}
	}
	@Test
	public void test5(){
		Result result=orderService.loadAllOrderByPage(1);
		System.out.println(result.getMsg());
		List<Order> os=(List<Order>) result.getData();
		for(Order o:os){
			System.out.println(o);
		}
	}
	@Test
	public void test4(){
		Result result=orderService.updateOrderStatus(4);
		System.out.println(result.getMsg());
	}
	@Test
	public void test3(){
		Result result=orderService.loadOrderById(3);
		System.out.println(result.getMsg());
		OrderResult or=(OrderResult) result.getData();
		System.out.println(or);
	}
	@Test
	public void test2(){
		Result result=orderService.loadOrderByMemberId(16);
		System.out.println(result.getMsg());
		List<Order> os=(List<Order>) result.getData();
		for(Order o:os){
			System.out.println(o);
		}
	}
	@Test
	public void test1(){
		Result result=orderService.addOrder(16,3,1,8.00);
		System.out.println(result.getMsg());
	}
}
