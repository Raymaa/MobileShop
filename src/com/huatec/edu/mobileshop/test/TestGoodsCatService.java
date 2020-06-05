package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.GoodsCat;
import com.huatec.edu.mobileshop.service.GoodsCatService;
import com.huatec.edu.mobileshop.util.Result;

public class TestGoodsCatService {
	//获取GoodsCatDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	GoodsCatService goodsCatService=ac.getBean("goodsCatServiceImpl",GoodsCatService.class);
	
	@Test
	public void test9(){
		Result result=goodsCatService.loadUnionCatById(2);
		System.out.println(result.getMsg());
		GoodsCat gc=(GoodsCat) result.getData();
		System.out.println(gc);
	}
	@Test
	public void test8(){
		Result result=goodsCatService.updateGoodsCount(1,1);
		System.out.println(result.getMsg());
	}
	@Test
	public void test7(){
		Result result=goodsCatService.deleteCatById(2);
		System.out.println(result.getMsg());
	}
	@Test
	public void test6(){
		Result result=goodsCatService.updateCat(13, "test", 1, 7, 1, "");
		System.out.println(result.getMsg());
	}
	@Test
	public void test5(){
		Result result=goodsCatService.loadShowCatByParentId(1);
		System.out.println(result.getMsg());
		List<GoodsCat> gcs=(List<GoodsCat>) result.getData();
		for(GoodsCat gc:gcs){
			System.out.println(gc);
		}
	}
	@Test
	public void test4(){
		Result result=goodsCatService.loadShowTopCat();
		System.out.println(result.getMsg());
		List<GoodsCat> gcs=(List<GoodsCat>) result.getData();
		for(GoodsCat gc:gcs){
			System.out.println(gc);
		}
	}
	@Test
	public void test3(){
		Result result=goodsCatService.loadCatByParentId(1);
		System.out.println(result.getMsg());
		List<GoodsCat> gcs=(List<GoodsCat>) result.getData();
		for(GoodsCat gc:gcs){
			System.out.println(gc);
		}
	}
	@Test
	public void test2(){
		Result result=goodsCatService.loadTopCat();
		System.out.println(result.getMsg());
		List<GoodsCat> gcs=(List<GoodsCat>) result.getData();
		for(GoodsCat gc:gcs){
			System.out.println(gc);
		}
	}
	@Test
	public void test1(){
		Result result=goodsCatService.addCat("茶饮料test2", 1, 17);
		System.out.println(result.getMsg());
	}
}
