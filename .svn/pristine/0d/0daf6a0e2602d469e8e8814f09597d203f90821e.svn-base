package com.huatec.edu.mobileshop.test.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.service.BrandService;
import com.huatec.edu.mobileshop.util.Result;

public class TestBrandService1 {
	//获取BrandService1
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	BrandService1 brandService1=ac.getBean("brandServiceImpl1",BrandService1.class);
	@Test
	public void test1(){
		Result result=brandService1.addBrand("test_brand004", "", "test", "", "");
		System.out.println(result.getMsg());
	}
}
