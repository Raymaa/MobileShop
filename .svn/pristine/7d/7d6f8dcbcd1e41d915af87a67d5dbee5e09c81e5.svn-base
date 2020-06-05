package com.huatec.edu.mobileshop.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.TagBrandDao;
import com.huatec.edu.mobileshop.entity.TagBrand;

public class TestTagBrandDao {
	//获取TagBrandDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	TagBrandDao tagBrandDao=ac.getBean("tagBrandDao",TagBrandDao.class);
	
	@Test
	public void test2(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tag_id", 3);
		map.put("brand_id", 3);
		TagBrand tb=tagBrandDao.findRepeat(map);
		System.out.println(tb);
	}
	@Test
	public void test1(){
		TagBrand tb=new TagBrand();
		tb.setId(null);
		tb.setTag_id(4);
		tb.setBrand_id(2);
		tb.setSort(0);
		tb.setCreatime(null);
		tb.setModifytime(null);
		tagBrandDao.save(tb);
	}
}
