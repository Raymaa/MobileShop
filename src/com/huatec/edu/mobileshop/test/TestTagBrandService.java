package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.TagBrand;
import com.huatec.edu.mobileshop.service.TagBrandService;
import com.huatec.edu.mobileshop.util.Result;

public class TestTagBrandService {
	//获取TagBrandService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	TagBrandService tagBrandService=ac.getBean("tagBrandServiceImpl",TagBrandService.class);
	
	@Test
	public void test4(){
		Result result=tagBrandService.deleteById(6);
		System.out.println(result.getMsg());
	}
	@Test
	public void test3(){
		Result result=tagBrandService.updateSortById(2, 5);
		System.out.println(result.getMsg());
	}
	@Test
	public void test2(){
		Result result=tagBrandService.loadByTagId(4);
		System.out.println(result.getMsg());
		List<TagBrand> tbs=(List<TagBrand>) result.getData();
		for(TagBrand tb:tbs){
			System.out.println(tb);
		}
	}
	@Test
	public void test1(){
		Result result=tagBrandService.add(4, 7);
		System.out.println(result.getMsg());
	}
}
