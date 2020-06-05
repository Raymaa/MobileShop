package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.GoodStoreDao;
import com.huatec.edu.mobileshop.entity.GoodStore;
import com.huatec.edu.mobileshop.util.Page;

public class TestGoodStoreDao {
	//获取GoodStoreDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	GoodStoreDao goodStoreDao=ac.getBean("goodStoreDao",GoodStoreDao.class);
	
	@Test
	public void test2(){
		Page page=new Page();
		page.setCurrent(1);
		page.setPageSize(5);
		List<GoodStore> gss=goodStoreDao.findUnionByPage(page);
		for(GoodStore gs:gss){
			System.out.println(gs);
		}
	}
	@Test
	public void test1(){
		GoodStore gs=goodStoreDao.findByGoodsId(20);
		System.out.println(gs);
	}
}
