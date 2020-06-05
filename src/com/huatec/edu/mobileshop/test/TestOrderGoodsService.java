package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.OrderGoods;
import com.huatec.edu.mobileshop.service.OrderGoodsService;
import com.huatec.edu.mobileshop.util.Result;

public class TestOrderGoodsService {
	//获取OrderGoodsService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	OrderGoodsService orderGoodsService=
			ac.getBean("orderGoodsServiceImpl",OrderGoodsService.class);
	
	/*@Test
	public void test1(){
		Result result=orderGoodsService.loadUnionByMemberId(16);
		System.out.println(result.getMsg());
		List<OrderGoods> ogs=(List<OrderGoods>) result.getData();
		for(OrderGoods og:ogs){
			System.out.println(og);
		}
	}*/
}
