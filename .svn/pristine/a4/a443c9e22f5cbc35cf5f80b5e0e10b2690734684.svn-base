package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.TypeBrandDao;
import com.huatec.edu.mobileshop.entity.TypeBrand;

public class TestTypeBrandDao {
	//获取TypeBrandDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	TypeBrandDao typeBrandDao=ac.getBean("typeBrandDao",TypeBrandDao.class);
	
	@Test
	public void test6(){
		List<TypeBrand> tbs=typeBrandDao.findUnionByTypeId(4);
		for(TypeBrand tb:tbs){
			System.out.println(tb);
		}
	}
	@Test
	public void test5(){
		TypeBrand tb=typeBrandDao.findUnionById(2);
		System.out.println(tb);
	}
	@Test
	public void test4(){
		List<TypeBrand> tbs=typeBrandDao.findUnion();
		for(TypeBrand tb:tbs){
			System.out.println(tb);
		}
	}
	@Test
	public void test3(){
		List<TypeBrand> tbs=typeBrandDao.findUnionByBrandId(5);
		for(TypeBrand tb:tbs){
			System.out.println(tb);
		}
	}
	@Test
	public void test2(){
		List<TypeBrand> tbs=typeBrandDao.findByBrandId(2);
		for(TypeBrand tb:tbs){
			System.out.println(tb);
		}
		if(tbs.isEmpty()){
			System.out.println("tbs--null");
		}
	}
	@Test
	public void test1(){
		List<TypeBrand> tbs=typeBrandDao.findByTypeId(13);
		for(TypeBrand tb:tbs){
			System.out.println(tb);
		}
		if(tbs.isEmpty()){
			System.out.println("tbs--null");
		}
	}
}
