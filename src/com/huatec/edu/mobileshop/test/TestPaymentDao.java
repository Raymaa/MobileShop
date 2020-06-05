package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.PaymentDao;
import com.huatec.edu.mobileshop.entity.Payment;

public class TestPaymentDao {
	//获取PaymentDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	PaymentDao paymentDao=ac.getBean("paymentDao",PaymentDao.class);
	
	@Test
	public void test5(){
		paymentDao.deleteById(1);
	}
	@Test
	public void test4(){
		Payment payment=new Payment();
		payment.setPayment_id(1);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		payment.setPaytime(now);
		paymentDao.dynamicUpdate(payment);
	}
	@Test
	public void test3(){
		Payment p=paymentDao.findById(1);
		System.out.println(p);
	}
	@Test
	public void test2(){
		List<Payment> ps=paymentDao.findAll();
		for(Payment p:ps){
			System.out.println(p);
		}
	}
	@Test
	public void test1(){
		Payment payment=new Payment();
		payment.setPayment_id(null);
		Random r=new Random();
		Long time=new Date().getTime();
		payment.setSn("16"+time+r.nextInt(100));
		payment.setPaytype_id(1);
		payment.setAmount(139.1);
		payment.setStatus(0);
		payment.setPaytime(null);
		payment.setRemark("");
		paymentDao.save(payment);
	}
}
