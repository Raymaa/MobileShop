package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.Admin;
import com.huatec.edu.mobileshop.service.AdminService;
import com.huatec.edu.mobileshop.util.Result;

public class TestAdminService {
	//获取AdminService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	AdminService adminService=ac.getBean("adminServiceImpl",AdminService.class);
	
	@Test
	public void test8(){
		Result result=adminService.loadAdminById(3);
		System.out.println(result.getMsg());
		Admin admin=(Admin) result.getData();
		System.out.println(admin);
	}
	@Test
	public void test7(){
		Result result=adminService.deleteAdminById(2);
		System.out.println(result.getMsg());
	}
	@Test
	public void test6(){
		Result result=adminService.loadAllAdmin();
		System.out.println(result.getMsg());
		List<Admin> as=(List<Admin>) result.getData();
		for(Admin a:as){
			System.out.println(a);
		}
	}
	@Test
	public void test5(){
		Result result=adminService.updateInfo(4, "18976544321", "王五五",1);
		System.out.println(result.getMsg());
	}
	@Test
	public void test4(){
		Result result=adminService.updateAdmin(4, "www2016", "123456", "www@qq.com", 1);
		System.out.println(result.getMsg());
	}
	@Test
	public void test3(){
		Result result=adminService.checkLogin("zs@qq.com", "123456");
		System.out.println(result);
	}
	@Test
	public void test2(){
		String email="ASa_123@163.com";
		String mobile="13398765432";
		String regexMobile="\\d{11}";
		boolean matches1=mobile.matches(regexMobile);
		System.out.println(matches1);
		String regexEmail="\\w+@\\w+(\\.[a-zA-Z]+)+";
		boolean matches2=email.matches(regexEmail);
		System.out.println(matches2);
	}
	@Test
	public void test1(){
		Result result=adminService.addAdmin("15884533341", "test", 1);
		System.out.println(result.getMsg());
	}
}
