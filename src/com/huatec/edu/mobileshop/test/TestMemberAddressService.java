package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.MemberAddress;
import com.huatec.edu.mobileshop.entity.brief.BriefMemberAddress;
import com.huatec.edu.mobileshop.service.MemberAddressService;
import com.huatec.edu.mobileshop.util.Result;

public class TestMemberAddressService {
	//获取MemberAddressService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	MemberAddressService addressService=ac.getBean("memberAddressServiceImpl",MemberAddressService.class);
	
	@Test
	public void test6(){
		Result result=addressService.loadByMemberId(16);
		List<BriefMemberAddress> bmas=(List<BriefMemberAddress>) result.getData();
		for(BriefMemberAddress bma:bmas){
			System.out.println(bma);
		}
	}
	@Test
	public void test5(){
		Result result=addressService.loadAddressesByMemberId(16);
		System.out.println(result.getMsg());
		List<MemberAddress> mas=(List<MemberAddress>) result.getData();
		if(mas!=null){
			for(MemberAddress ma:mas){
				System.out.println(ma);
			}
		}
	}
	@Test
	public void test4(){
		Result result=addressService.updateAddress(17, "广东省", "深圳市", "罗湖区", "国贸", 
				"13567892345", "王爽");
		System.out.println(result.getMsg());
	}
	@Test
	public void test3(){
		Result result=addressService.deleteAddressById(10);
		System.out.println(result.getMsg());
	}
	@Test
	public void test2(){
		Result result=addressService.loadAddressById(2);
		System.out.println(result.getMsg());
		MemberAddress ma=(MemberAddress) result.getData();
		System.out.println(ma);
	}
	@Test
	public void test1(){
		Result result=addressService.addAddress(5, "广西省", "桂林市", "桂林", "", "19867894532", "张珊珊");
		System.out.println(result.getMsg());
		MemberAddress ma=(MemberAddress) result.getData();
		System.out.println(ma);
	}
}
