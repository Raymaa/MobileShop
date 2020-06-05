package com.huatec.edu.mobileshop.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.OrderGoodsDao;
import com.huatec.edu.mobileshop.entity.OrderGoods;

public class TestOrderGoodsDao {
	//获取OrderGoodsDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	OrderGoodsDao orderGoodsDao=ac.getBean("orderGoodsDao",OrderGoodsDao.class);
	
	@Test
	public void test7(){
		List<OrderGoods> ogs=orderGoodsDao.findUnionByOrderId(3);
		for(OrderGoods og:ogs){
			System.out.println(og);
		}
	}
	@Test
	public void test6(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("order_id", 3);
		map.put("goods_id", 2);
		OrderGoods og=orderGoodsDao.findRepeat(map);
		System.out.println(og);
	}
	/*@Test
	public void test5(){
		List<OrderGoods> ogs=orderGoodsDao.findUnionByMemberId(16);
		for(OrderGoods og:ogs){
			System.out.println(og);
		}
	}*/
	@Test
	public void test4(){
		orderGoodsDao.deleteById(1);
	}
	@Test
	public void test3(){
		OrderGoods og=orderGoodsDao.findById(1);
		System.out.println(og);
	}
	@Test
	public void test2(){
		List<OrderGoods> ogs=orderGoodsDao.findAll();
		for(OrderGoods og:ogs){
			System.out.println(og);
		}
	}
	@Test
	public void test1(){
		OrderGoods og=new OrderGoods();
		og.setId(null);
		og.setOrder_id(1);
		og.setGoods_id(11);
		og.setGoods_num(4);
		og.setPrice(9.9);
		orderGoodsDao.save(og);
		System.out.println(9.9*4);
	}
}
