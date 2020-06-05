package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.Role;
import com.huatec.edu.mobileshop.service.RoleService;
import com.huatec.edu.mobileshop.util.Result;

public class TestRoleService {
	//获取RoleService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	RoleService roleService=ac.getBean("roleServiceImpl",RoleService.class);
	
	@Test
	public void test4(){
		Result result=roleService.deleteRoleById(5);
		System.out.println(result.getMsg());
	}
	@Test
	public void test3(){
		Result result=roleService.updateRole(5, "测试", "test11");
		System.out.println(result.getMsg());
	}
	@Test
	public void test2(){
		Result result=roleService.loadAllRole();
		System.out.println(result.getMsg());
		List<Role> rs=(List<Role>) result.getData();
		for(Role r:rs){
			System.out.println(r);
		}
	}
	@Test
	public void test1(){
		Result result=roleService.addRole("test", "test");
		System.out.println(result.getMsg());
	}
}
