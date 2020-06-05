package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.GoodsLike;
import com.huatec.edu.mobileshop.service.GoodsLikeService;
import com.huatec.edu.mobileshop.util.Result;

public class TestGoodsLikeService {
	//获取GoodsLikeService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	GoodsLikeService goodsLikeService=ac.getBean("goodsLikeServiceImpl",GoodsLikeService.class);
	
	@Test
	public void test3(){
		Result result=goodsLikeService.deleteById(7);
		System.out.println(result.getMsg());
	}
	@Test
	public void test2(){
		Result result=goodsLikeService.loadByMemberId(16);
		System.out.println(result.getMsg());
		List<GoodsLike> gls=(List<GoodsLike>) result.getData();
		for(GoodsLike gl:gls){
			System.out.println(gl);
		}
	}
	@Test
	public void test1(){
		Result result=goodsLikeService.add(2, 16);
		System.out.println(result.getMsg());
	}
}
