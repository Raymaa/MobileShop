package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.Cart;
import com.huatec.edu.mobileshop.service.CartService;
import com.huatec.edu.mobileshop.util.Result;

public class TestCartService {
	//获取CartService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	CartService cartService=ac.getBean("cartServiceImpl",CartService.class);
	
	@Test
	public void test6(){
		Result result=cartService.loadChooseCartByMemberId(16);
		System.out.println(result.getMsg());
		List<Cart> cs=(List<Cart>) result.getData();
		for(Cart c:cs){
			System.out.println(c);
		}
	}
	@Test
	public void test5(){
		Result result=cartService.updateChoose(12, 0);
		System.out.println(result.getMsg());
	}
	@Test
	public void test4(){
		Result result=cartService.deleteCartById(1);
		System.out.println(result.getMsg());
	}
	@Test
	public void test3(){
		Result result=cartService.updateCart(2, 3, 1);
		System.out.println(result.getMsg());
	}
	@Test
	public void test2(){
		Result result=cartService.loadCartByMemberId(16);
		System.out.println(result.getMsg());
		List<Cart> cs=(List<Cart>) result.getData();
		for(Cart c:cs){
			System.out.println(c);
		}
	}
	@Test
	public void test1(){
		Result result=cartService.addCart(16, 29, 2);
		System.out.println(result.getMsg());
	}
}
