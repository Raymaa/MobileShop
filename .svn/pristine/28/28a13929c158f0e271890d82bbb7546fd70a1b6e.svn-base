package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.GoodsCommentDao;
import com.huatec.edu.mobileshop.entity.GoodsComment;

public class TestGoodsCommentDao {
	//获取GoodsCommentDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	GoodsCommentDao goodsCommentDao=ac.getBean("goodsCommentDao",GoodsCommentDao.class);
	
	@Test
	public void test7(){
		List<GoodsComment> gcs=goodsCommentDao.findUnionByMemberId(16);
		for(GoodsComment gc:gcs){
			System.out.println(gc);
		}
	}
	@Test
	public void test6(){
		List<GoodsComment> gcs=goodsCommentDao.findUnionByGoodsId(29);
		for(GoodsComment gc:gcs){
			System.out.println(gc);
		}
	}
	@Test
	public void test5(){
		goodsCommentDao.deleteById(1);
	}
	@Test
	public void test4(){
		GoodsComment gc=new GoodsComment();
		gc.setComment_id(1);
		gc.setContent("好，good");
		goodsCommentDao.dynamicUpdate(gc);
	}
	@Test
	public void test3(){
		GoodsComment gc=goodsCommentDao.findById(1);
		System.out.println(gc);
	}
	@Test
	public void test2(){
		List<GoodsComment> gcs=goodsCommentDao.findAll();
		for(GoodsComment gc:gcs){
			System.out.println(gc);
		}
	}
	@Test
	public void test1(){
		GoodsComment gc=new GoodsComment();
		gc.setComment_id(null);
		gc.setOrder_id(3);
		gc.setGoods_id(11);
		gc.setMember_id(16);
		gc.setScore(5);
		gc.setContent("很好");
		gc.setIsopen(1);
		gc.setCreatime(null);
		goodsCommentDao.save(gc);
	}
}
