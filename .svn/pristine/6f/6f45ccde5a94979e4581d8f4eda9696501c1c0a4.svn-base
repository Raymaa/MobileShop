package com.huatec.edu.mobileshop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.service.LogiService;
import com.huatec.edu.mobileshop.util.Result;

public class TestLogiService {
	//获取LogiService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	LogiService logiService=ac.getBean("logiServiceImpl",LogiService.class);
	
	@Test
	public void test2(){
		Result result=logiService.updateLogiStatus(7);
		System.out.println(result.getMsg());
	}
	@Test
	public void test1(){
		Result result=logiService.updateLogi(7, 3, "yt20161202008", "李四");
		System.out.println(result.getMsg());
	}
}
