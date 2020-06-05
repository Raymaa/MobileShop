package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.LogiDao;
import com.huatec.edu.mobileshop.entity.Logi;

public class TestLogiDao {
	//获取LogiDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	LogiDao logiDao=ac.getBean("logiDao",LogiDao.class);
	
	@Test
	public void test5(){
		logiDao.deleteById(1);
	}
	@Test
	public void test4(){
		Logi logi=new Logi();
		logi.setLogi_id(2);
		logi.setSn("20161125001");
		logi.setCarriage(0.00);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		logi.setModifytime(now);
		logiDao.dynamicUpdate(logi);
	}
	@Test
	public void test3(){
		Logi l=logiDao.findById(1);
		System.out.println(l);
	}
	@Test
	public void test2(){
		List<Logi> ls=logiDao.findAll();
		for(Logi l:ls){
			System.out.println(l);
		}
	}
	@Test
	public void test1(){
		Logi logi=new Logi();
		logi.setLogi_id(null);
		logi.setShip_id(2);
		logi.setSn("");
		logi.setCarriage(8.00);
		logi.setSender("张三");
		logi.setStatus(1);
		logi.setCreatime(null);
		logi.setModifytime(null);
		logiDao.save(logi);
	}
}
