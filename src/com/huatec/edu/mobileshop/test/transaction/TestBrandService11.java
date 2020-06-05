package com.huatec.edu.mobileshop.test.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.service.BrandService;
import com.huatec.edu.mobileshop.util.Result;

public class TestBrandService11 {
	//获取BrandService11
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	BrandService1 brandService11=ac.getBean("brandServiceImpl11",BrandService1.class);
	@Test
	public void test1(){
		Result result=brandService11.addBrand("test_brand004", "", "test", "", "");
		System.out.println(result.getMsg());
	}
}
