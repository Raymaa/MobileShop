package com.huatec.edu.mobileshop.test;

import java.io.File;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.service.GoodsImgService;
import com.huatec.edu.mobileshop.util.Result;

public class TestGoodsImgService {
	//获取GoodsImgService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	GoodsImgService goodsImgService=ac.getBean("goodsImgServiceImpl",GoodsImgService.class);
	
	@Test
	public void test4(){
		Result result=goodsImgService.deleteImgById(4, "http://localhost:8080");
		System.out.println(result.getMsg());
	}
	@Test
	public void test3(){
		File f=new File("E:\\javashop\\wtpwebapps\\MobileShop\\upload\\1CbLEaNoW\\HTeNW+jso3Tw==.jpg");
//		File f=new File("http://localhost:8080/MobileShop/upload/TAD4VVy26XAq1G97Essseg==_big.jpg");
		System.out.println("name:"+f.getName());
		System.out.println(f.getAbsolutePath());
		System.out.println(f.getParent());
//		if(f.exists()){
//			f.delete();
//		}
	}
	@Test
	public void test2(){
		Result result=goodsImgService.updateImg(3, 
				"E:\\javashop\\wtpwebapps\\MobileShop\\upload\\7y71Rlz+aH4YfFD56e\\XJQ==.jpg",
				"http://localhost:8080");
		System.out.println(result.getMsg());
	}
	@Test
	public void test1(){
		Result result=goodsImgService.addImg(2, 0, "", "");
		System.out.println(result.getMsg());
	}
}
