package com.huatec.edu.mobileshop.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.GoodsImgDao;
import com.huatec.edu.mobileshop.entity.GoodsImg;

public class TestGoodsImgDao {
	//获取GoodsImgDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	GoodsImgDao goodsImgDao=ac.getBean("goodsImgDao",GoodsImgDao.class);
	
	@Test
	public void test1(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("goods_id", 2);
		map.put("isdefault", 0);
		GoodsImg gi=goodsImgDao.findByGoodsIdAndIsdefault(map);
		System.out.println(gi);
	}
}
