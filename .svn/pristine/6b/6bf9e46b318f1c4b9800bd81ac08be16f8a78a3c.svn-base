package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.TypeBrand;
import com.huatec.edu.mobileshop.service.TypeBrandService;
import com.huatec.edu.mobileshop.util.Result;

public class TestTypeBrandService {
	//获取TypeBrandService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	TypeBrandService typeBrandService=ac.getBean("typeBrandServiceImpl",TypeBrandService.class);
	
	@Test
	public void test7(){
		Result result=typeBrandService.loadById(2);
		System.out.println(result.getMsg());
		TypeBrand tb=(TypeBrand) result.getData();
		System.out.println(tb);
	}
	@Test
	public void test6(){
		Result result=typeBrandService.loadAll();
		System.out.println(result.getMsg());
		List<TypeBrand> tbs=(List<TypeBrand>) result.getData();
		for(TypeBrand tb:tbs){
			System.out.println(tb);
		}
	}
	@Test
	public void test5(){
		Result result=typeBrandService.deleteById(8);
		System.out.println(result.getMsg());
	}
	@Test
	public void test4(){
		Result result=typeBrandService.update(2, 4, 7);
		System.out.println(result.getMsg());
	}
	@Test
	public void test3(){
		Result result=typeBrandService.loadByBrandId(5);
		System.out.println(result.getMsg());
		List<TypeBrand> tbs=(List<TypeBrand>) result.getData();
		if(tbs!=null){
			for(TypeBrand tb:tbs){
				System.out.println(tb);
			}
		}
	}
	@Test
	public void test2(){
		Result result=typeBrandService.loadByTypeId(4);
		System.out.println(result.getMsg());
		List<TypeBrand> tbs=(List<TypeBrand>) result.getData();
		if(tbs!=null){
			for(TypeBrand tb:tbs){
				System.out.println(tb);
			}
		}
	}
	@Test
	public void test1(){
		Result result=typeBrandService.add(4, 7);
		System.out.println(result.getMsg());
	}
}
