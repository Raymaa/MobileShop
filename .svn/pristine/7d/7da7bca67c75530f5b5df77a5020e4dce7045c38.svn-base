package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.Brand;
import com.huatec.edu.mobileshop.service.BrandService;
import com.huatec.edu.mobileshop.util.Result;

public class TestBrandService {
	//获取BrandService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	BrandService brandService=ac.getBean("brandServiceImpl",BrandService.class);
	
	@Test
	public void test7(){
		Result result=brandService.loadBrandByDisabled();
		System.out.println(result.getMsg());
		List<Brand> brands=(List<Brand>) result.getData();
		for(Brand b:brands){
			System.out.println(b);
		}
	}
	@Test
	public void test6(){
		Result result=brandService.updateDisabled(10, 0);
		System.out.println(result.getMsg());
	}
	@Test
	public void test5(){
		Result result=brandService.deleteBrandById(12);
		System.out.println(result.getMsg());
	}
	@Test
	public void test4(){
		Result result=brandService.updateBrand(11, "范思哲Versace", "", "女装、男装、香水", 
				"该品牌创立于1978年，品牌标志是神话中的蛇妖美杜莎（Medusa），代表着致命的吸引力", 
				"http://www.versace.com");
		System.out.println(result.getMsg());
	}
	@Test
	public void test3(){
		Result result=brandService.loadBrandById(3);
		System.out.println(result.getMsg());
		Brand brand=(Brand) result.getData();
		System.out.println(brand);
	}
	@Test
	public void test2(){
		Result result=brandService.loadAllBrandsByPage(1);
		System.out.println(result.getMsg());
		List<Brand> brands=(List<Brand>) result.getData();
		for(Brand b:brands){
			System.out.println(b);
		}
	}
	@Test
	public void test1(){
		Result result=brandService.addBrand("test_brand004", "", "test", "", "");
		System.out.println(result.getMsg());
	}
}
