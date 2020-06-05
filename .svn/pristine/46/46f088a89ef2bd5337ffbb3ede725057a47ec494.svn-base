package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.GoodStore;
import com.huatec.edu.mobileshop.service.GoodStoreService;
import com.huatec.edu.mobileshop.util.Result;

public class TestGoodStoreService {
	//获取GoodsTypeService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	GoodStoreService goodStoreService=ac.getBean("goodStoreServiceImpl",
			GoodStoreService.class);
	
	@Test
	public void test4(){
		Result result=goodStoreService.deleteStoreById(7);
		System.out.println(result.getMsg());
	}
	@Test
	public void test3(){
		Result result=goodStoreService.updateStore(3, 20);
		System.out.println(result.getMsg());
	}
	@Test
	public void test2(){
		Result result=goodStoreService.loadAllStore(1);
		System.out.println(result.getMsg());
		List<GoodStore> gss=(List<GoodStore>) result.getData();
		for(GoodStore gs:gss){
			System.out.println(gs);
		}
	}
	@Test
	public void test1(){
		Result result=goodStoreService.addStore(20, 100);
		System.out.println(result.getMsg());
	}
}
