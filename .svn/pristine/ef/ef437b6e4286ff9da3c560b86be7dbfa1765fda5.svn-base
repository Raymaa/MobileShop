package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.Tag;
import com.huatec.edu.mobileshop.entity.brief.BriefTag;
import com.huatec.edu.mobileshop.service.TagService;
import com.huatec.edu.mobileshop.util.Result;

public class TestTagService {
	//获取TagService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	TagService tagService=ac.getBean("tagServiceImpl",TagService.class);
	
	@Test
	public void test9(){
		Result result=tagService.deleteTagById(16);
		System.out.println(result.getMsg());
	}
	@Test
	public void test8(){
		Result result=tagService.updateTag(16, "testsp01", 0, 6, 2, 1);
		System.out.println(result.getMsg());
	}
	@Test
	public void test7(){
		Result result=tagService.loadTagById(2);
		System.out.println(result.getMsg());
		Tag t=(Tag) result.getData();
		System.out.println(t);
	}
	@Test
	public void test6(){
		Result result=tagService.loadAllBrandByTeam(0);
		System.out.println(result.getMsg());
		List<BriefTag> bts=(List<BriefTag>) result.getData();
		for(BriefTag bt:bts){
			System.out.println(bt);
		}
	}
	@Test
	public void test5(){
		Result result=tagService.loadAllGoodsByTeam(1);
		System.out.println(result.getMsg());
		List<BriefTag> bts=(List<BriefTag>) result.getData();
		for(BriefTag bt:bts){
			System.out.println(bt);
		}
	}
	@Test
	public void test4(){
		Result result=tagService.loadAllBrandTag();
		System.out.println(result.getMsg());
		List<Tag> ts=(List<Tag>) result.getData();
		for(Tag t:ts){
			System.out.println(t);
		}
	}
	
	@Test
	public void test3(){
		Result result=tagService.loadAllGoodsTag();
		System.out.println(result.getMsg());
		List<Tag> ts=(List<Tag>) result.getData();
		for(Tag t:ts){
			System.out.println(t);
		}
	}
	@Test
	public void test2(){
		Result result=tagService.loadAllTagsByPage(1);
		System.out.println(result.getMsg());
		List<Tag> tags=(List<Tag>) result.getData();
		for(Tag t:tags){
			System.out.println(t);
		}
	}
	@Test
	public void test1(){
		Result result=tagService.addTag("spbq01", 0, 5, 1);
		System.out.println(result.getMsg());
	}
}
