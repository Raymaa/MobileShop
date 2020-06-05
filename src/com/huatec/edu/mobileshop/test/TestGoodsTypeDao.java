package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.GoodsTypeDao;
import com.huatec.edu.mobileshop.entity.GoodsType;

public class TestGoodsTypeDao {
	//获取goodsTypeDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	GoodsTypeDao goodsTypeDao=ac.getBean("goodsTypeDao",GoodsTypeDao.class);
	
	@Test
	public void test2(){
		List<GoodsType> gts=goodsTypeDao.findByDisabled(0);
		for(GoodsType gt:gts){
			System.out.println(gt);
		}
	}
	@Test
	public void test1(){
		GoodsType goodsType=goodsTypeDao.findByName("酒水");
		System.out.println(goodsType);
	}
}
