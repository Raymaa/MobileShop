package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.RoleDao;
import com.huatec.edu.mobileshop.entity.Role;

public class TestRoleDao {
	//获取RoleDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	RoleDao roleDao=ac.getBean("roleDao",RoleDao.class);
	
	@Test
	public void test6(){
		Role role=roleDao.findByName("超级管理员");
		System.out.println(role);
	}
	@Test
	public void test5(){
		roleDao.deleteById(4);
	}
	@Test
	public void test4(){
		Role role=new Role();
		role.setRole_id(4);
		role.setDescription("test");
		Timestamp now=new Timestamp(System.currentTimeMillis());
		role.setModifytime(now);
		roleDao.dynamicUpdate(role);
	}
	@Test
	public void test3(){
		Role r=roleDao.findById(1);
		System.out.println(r);
	}
	@Test
	public void test2(){
		List<Role> rs=roleDao.findAll();
		for(Role r:rs){
			System.out.println(r);
		}
	}
	@Test
	public void test1(){
		Role role=new Role();
		role.setRole_id(null);
		role.setName("测试");
		role.setDescription("测试");
		role.setCreatime(null);
		role.setModifytime(null);
		roleDao.save(role);
	}
}
