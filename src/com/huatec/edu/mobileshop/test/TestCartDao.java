package com.huatec.edu.mobileshop.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.CartDao;
import com.huatec.edu.mobileshop.entity.Cart;

public class TestCartDao {
	//获取CartDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	CartDao cartDao=ac.getBean("cartDao",CartDao.class);
	
	@Test
	public void test7(){
		Cart cart=new Cart();
		cart.setMember_id(16);
		List<Cart> carts=cartDao.dynamicFind(cart);
		for(Cart c:carts){
			System.out.println(c);
		}
	}
	@Test
	public void test6(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("member_id", 16);
		map.put("choose", 0);
		List<Cart> carts=cartDao.findUnionByMemberId(map);
		for(Cart c:carts){
			System.out.println(c);
		}
	}
	@Test
	public void test5(){
		Cart cart=new Cart();
		cart.setCart_id(1);
		cart.setGoods_num(2);
		cart.setAmount(2*24.99);
		cartDao.dynamicUpdate(cart);
	}
	@Test
	public void test4(){
		cartDao.deleteById(3);
	}
	@Test
	public void test3(){
		Cart c=cartDao.findById(1);
		System.out.println(c);
	}
	@Test
	public void test2(){
		List<Cart> carts=cartDao.findAll();
		for(Cart c:carts){
			System.out.println(c);
		}
	}
	@Test
	public void test1(){
		Cart cart=new Cart();
		cart.setCart_id(null);
		cart.setMember_id(16);
		cart.setGoods_id(31);
		cart.setGoods_num(1);
		cart.setChoose(1);
		cart.setAmount(28.9);
		cart.setCreatime(null);
		cart.setModifytime(null);
		cartDao.save(cart);
		System.out.println(cart.getCart_id());
	}
}
