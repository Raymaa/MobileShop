package com.huatec.edu.mobileshop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.service.PaymentService;
import com.huatec.edu.mobileshop.util.Result;

public class TestPaymentService {
	//获取PaymentService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	PaymentService paymentService=ac.getBean("paymentServiceImpl",PaymentService.class);
	
	@Test
	public void test1(){
		Result result=paymentService.updatePayment(7);
		System.out.println(result.getMsg());
	}

}
