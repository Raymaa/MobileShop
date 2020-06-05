package com.huatec.edu.mobileshop.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.MemberDao;
import com.huatec.edu.mobileshop.entity.Member;

public class TestMemberDao {
	//获取MemberDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	MemberDao memberDao=ac.getBean("memberDao",MemberDao.class);
	@Test
	public void test5(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("uname", "test");
		Member member=memberDao.dynamicFind(map);
		System.out.println(member);
	}
	@Test
	public void test4(){
		Member m=memberDao.findById(16);
		System.out.println(m);
	}
	@Test
	public void test3(){
		Member m=memberDao.findByEmail("ww@qq.com");
		System.out.println(m);
	}
	@Test
	public void test2(){
		Member m=memberDao.findByName("李四");
		System.out.println(m);
	}
	@Test
	public void test1(){
		List<Member> ms=memberDao.findAll();
		for(Member m:ms){
			System.out.println(m);
		}
	}
}
