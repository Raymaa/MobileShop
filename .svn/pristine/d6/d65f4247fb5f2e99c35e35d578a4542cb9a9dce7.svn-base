package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.PayTypeDao;
import com.huatec.edu.mobileshop.entity.PayType;

public class TestPayTypeDao {
	//获取PayTypeDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	PayTypeDao payTypeDao=ac.getBean("payTypeDao",PayTypeDao.class);
	
	@Test
	public void test6(){
		PayType payType=new PayType();
		payType.setPaytype_id(1);
		payType.setDescription("支付宝（中国）网络技术有限公司是国内领先的第三方支付平台，致力于提供“简单、安全、快速”的支付解决方案。");
		payTypeDao.dynamicUpdate(payType);
	}
	@Test
	public void test5(){
		PayType pt=payTypeDao.findByName("支付宝");
		System.out.println(pt);
	}
	@Test
	public void test4(){
		PayType pt=payTypeDao.findById(2);
		System.out.println(pt);
	}
	@Test
	public void test3(){
		payTypeDao.deleteById(4);
	}
	@Test
	public void test2(){
		List<PayType> pts=payTypeDao.findAll();
		for(PayType pt:pts){
			System.out.println(pt);
		}
	}
	@Test
	public void test1(){
		PayType payType=new PayType();
		payType.setPaytype_id(null);
		payType.setName("微信test");
		payType.setConfig("");
		payType.setDescription("");
		payType.setCreatime(null);
		payType.setModifytime(null);
		payTypeDao.save(payType);
	}
}
