package com.huatec.edu.mobileshop.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.GoodsDao;
import com.huatec.edu.mobileshop.entity.Goods;
import com.huatec.edu.mobileshop.entity.brief.BriefGoods;
import com.huatec.edu.mobileshop.util.Page;

public class TestGoodsDao {
	//获取GoodsDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	GoodsDao goodsDao=ac.getBean("goodsDao",GoodsDao.class);
	
	@Test
	public void test6(){
		Page page=new Page();
		page.setCurrent(1);
		page.setPageSize(5);
		List<BriefGoods> bgs=goodsDao.findAllEnableByPage(page);
		for(BriefGoods bg:bgs){
			System.out.println(bg);
		}
	}
	@Test
	public void test5(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", "%汇源%");
		map.put("mkt_enable", 0);
		List<BriefGoods> bgs=goodsDao.dynamicFind(map);
		for(BriefGoods bg:bgs){
			System.out.println(bg);
		}
	}
	@Test
	public void test4(){
		Goods g=goodsDao.findUnionById(2);
		System.out.println(g);
	}
	@Test
	public void test3(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("cat_id", 2);
		map.put("mkt_enable", 0);
		List<BriefGoods> bgs=goodsDao.dynamicFind(map);
		for(BriefGoods bg:bgs){
			System.out.println(bg);
		}
	}
	@Test
	public void test2(){
		Page page=new Page();
		page.setCurrent(1);
		page.setPageSize(3);
		List<BriefGoods> bgs=goodsDao.findUnionByPage(page);
		for(BriefGoods bg:bgs){
			System.out.println(bg);
		}
	}
	@Test
	public void test1(){
		BriefGoods bg=goodsDao.findByName("汇源果汁 100%纯果汁 苹果汁");
		System.out.println(bg);
	}
}
