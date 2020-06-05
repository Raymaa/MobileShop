package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.TagGoods;
import com.huatec.edu.mobileshop.service.TagGoodsService;
import com.huatec.edu.mobileshop.util.Result;

public class TestTagGoodsService {
	//获取TagGoodsService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	TagGoodsService tagGoodsService=ac.getBean("tagGoodsServiceImpl",TagGoodsService.class);
	
	@Test
	public void test4(){
		Result result=tagGoodsService.deleteById(7);
		System.out.println(result.getMsg());
	}
	@Test
	public void test3(){
		Result result=tagGoodsService.updateSortById(2, 2);
		System.out.println(result.getMsg());
	}
	@Test
	public void test2(){
		Result result=tagGoodsService.loadByTagId(2);
		System.out.println(result.getMsg());
		List<TagGoods> tgs=(List<TagGoods>) result.getData();
		for(TagGoods tg:tgs){
			System.out.println(tg);
		}
	}
	@Test
	public void test1(){
		Result result=tagGoodsService.add(6, 22);
		System.out.println(result.getMsg());
	}
}
