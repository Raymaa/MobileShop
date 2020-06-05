package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.GoodsComment;
import com.huatec.edu.mobileshop.service.GoodsCommentService;
import com.huatec.edu.mobileshop.util.Result;

public class TestGoodsCommentService {
	//获取GoodsCommentService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	GoodsCommentService goodsCommentService=ac.getBean("goodsCommentServiceImpl",GoodsCommentService.class);
	
	@Test
	public void test2(){
		Result result=goodsCommentService.loadCommentByGoodsId(29);
		System.out.println(result.getMsg());
		List<GoodsComment> gcs=(List<GoodsComment>) result.getData();
		for(GoodsComment gc:gcs){
			System.out.println(gc);
		}
	}
	@Test
	public void test1(){
		Result result=goodsCommentService.addComment(7, 29, 5, "good", 1);
		System.out.println(result.getMsg());
	}
}
