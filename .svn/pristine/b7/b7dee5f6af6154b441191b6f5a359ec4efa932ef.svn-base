package com.huatec.edu.mobileshop.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.TagDao;
import com.huatec.edu.mobileshop.entity.Tag;
import com.huatec.edu.mobileshop.entity.brief.BriefTag;
import com.huatec.edu.mobileshop.util.Page;

public class TestTagDao {
	//获取TagDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	TagDao tagDao=ac.getBean("tagDao",TagDao.class);
	
	@Test
	public void test6(){
		List<BriefTag> bts=tagDao.findUnionByBrandTagId(4);
		for(BriefTag bt:bts){
			System.out.println(bt);
		}
	}
	@Test
	public void test5(){
		List<BriefTag> bts=tagDao.findUnionByGoodsTagId(2);
		for(BriefTag bt:bts){
			System.out.println(bt);
		}
	}
	@Test
	public void test4(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("type", 0);
		map.put("team", 0);
		List<Tag> ts=tagDao.findByTypeAndTeam(map);
		for(Tag t:ts){
			System.out.println(t);
		}
	}
	@Test
	public void test3(){
		List<Tag> ts=tagDao.findByType(0);
		for(Tag t:ts){
			System.out.println(t);
		}
	}
	@Test
	public void test2(){
		Page page=new Page();
		page.setCurrent(1);
		page.setPageSize(5);
		List<Tag> ts=tagDao.findAllByPage(page);
		for(Tag t:ts){
			System.out.println(t);
		}
	}
	@Test
	public void test1(){
		Tag tag=tagDao.findByName("本周热卖");
		System.out.println(tag);
	}
}
