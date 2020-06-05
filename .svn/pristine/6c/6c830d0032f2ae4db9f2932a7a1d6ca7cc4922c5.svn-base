package com.huatec.edu.mobileshop.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.TagGoodsDao;
import com.huatec.edu.mobileshop.entity.TagGoods;

public class TestTagGoodsDao {
	//获取TagGoodsDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	TagGoodsDao tagGoodsDao=ac.getBean("tagGoodsDao",TagGoodsDao.class);
	
	@Test
	public void test4(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tag_id", 2);
		map.put("goods_id", 4);
		TagGoods tg=tagGoodsDao.findRepeat(map);
		System.out.println(tg);
	}
	@Test
	public void test3(){
		TagGoods tg=new TagGoods();
		tg.setId(null);
		tg.setTag_id(3);
		tg.setGoods_id(21);
		tg.setSort(0);
		tg.setCreatime(null);
		tg.setModifytime(null);
		tagGoodsDao.save(tg);
	}
	@Test
	public void test2(){
		List<TagGoods> tgs=tagGoodsDao.findUnionByTagId2(2);
		for(TagGoods tg:tgs){
			System.out.println(tg);
		}
	}
	@Test
	public void test1(){
		List<TagGoods> tgs=tagGoodsDao.findUnionByTagId(6);
		System.out.println(tgs.size());
		for(TagGoods tg:tgs){
			System.out.println(tg);
		}
	}
}
