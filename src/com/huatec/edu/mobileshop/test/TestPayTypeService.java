package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.PayType;
import com.huatec.edu.mobileshop.service.PayTypeService;
import com.huatec.edu.mobileshop.util.Result;

public class TestPayTypeService {
	//获取PayTypeService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	PayTypeService payTypeService=ac.getBean("payTypeServiceImpl",PayTypeService.class);
	
	@Test
	public void test5(){
		Result result=payTypeService.deletePayTypeById(5);
		System.out.println(result.getMsg());
	}
	@Test
	public void test4(){
		Result result=payTypeService.updatePayType(6, "快钱", "", "快钱");
		System.out.println(result.getMsg());
	}
	@Test
	public void test3(){
		Result result=payTypeService.loadPayTypeById(1);
		System.out.println(result.getMsg());
		PayType pt=(PayType) result.getData();
		System.out.println(pt);
	}
	@Test
	public void test2(){
		Result result=payTypeService.loadAllPayType();
		System.out.println(result.getMsg());
		List<PayType> pts=(List<PayType>) result.getData();
		for(PayType pt:pts){
			System.out.println(pt);
		}
	}
	@Test
	public void test1(){
		Result result=payTypeService.addPayType("块钱", "", "");
		System.out.println(result.getMsg());
	}
}
