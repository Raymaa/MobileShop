package com.huatec.edu.mobileshop.test;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.BrandDao;
import com.huatec.edu.mobileshop.entity.Brand;
import com.huatec.edu.mobileshop.util.Page;

public class TestBrandDao {
	//获取BrandDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	BrandDao brandDao=ac.getBean("brandDao",BrandDao.class);
	
	@Test
	public void test5(){
		Date d=new Date();
		Long time=d.getTime();
		System.out.println(d);
		Random r=new Random();
		String s="2"+time+r.nextInt(100);
		System.out.println(s);
	}
	@Test
	public void test4(){
		String s=UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(s);
	}
	@Test
	public void test3(){
		Page page=new Page();
		page.setCurrent(1);
		page.setPageSize(10);
		List<Brand> brands=brandDao.findAllByPage(page);
		for(Brand b:brands){
			System.out.println(b);
		}
	}
	@Test
	public void test2(){
		List<Brand> brands=brandDao.findByDisabled(0);
		System.out.println(brands);
		for(Brand b:brands){
			System.out.println(b);
		}
	}
	@Test
	public void test1(){
		Brand brand=brandDao.findByName("良品铺子");
		System.out.println(brand);
		
	}
}
