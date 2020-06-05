package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.GoodsType;
import com.huatec.edu.mobileshop.service.GoodsTypeService;
import com.huatec.edu.mobileshop.util.Result;

public class TestGoodsTypeService {
	//获取GoodsTypeService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	GoodsTypeService goodsTypeService=ac.getBean("goodsTypeServiceImpl",
			GoodsTypeService.class);
	@Test
	public void test7(){
		Result result=goodsTypeService.loadTypeByDisabled();
		System.out.println(result.getMsg());
		List<GoodsType> gts=(List<GoodsType>) result.getData();
		for(GoodsType gt:gts){
			System.out.println(gt);
		}
	}
	@Test
	public void test6(){
		Result result=goodsTypeService.updateDisabled(4, 1);
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
	}
	@Test
	public void test5(){
		Result result=goodsTypeService.deleteTypeById(5);
		System.out.println(result.getMsg());
	}
	@Test
	public void test4(){
		String[] paramsKey=new String[]{"风格", "衣长", "袖长", "流行元素", ""};
		Result result=goodsTypeService.updateType(18, "testfz", paramsKey, 0);
		System.out.println(result.getMsg());
	}
	@Test
	public void test3(){
		Result result=goodsTypeService.loadTypeById(4);
		System.out.println(result.getMsg());
		GoodsType gt=(GoodsType) result.getData();
		System.out.println(gt);
	}
	@Test
	public void test2(){
		Result result=goodsTypeService.loadAllTypes();
		System.out.println(result.getMsg());
		List<GoodsType> gts=(List<GoodsType>) result.getData();
		for(GoodsType gt:gts){
			System.out.println(gt);
		}
	}
	
	@Test
	public void test1(){
		String[] paramsKey=new String[]{"产地", "净含量", "保质期", "口味", ""};
		Result result=goodsTypeService.addType("testyl1", paramsKey, 0);
		System.out.println(result.getMsg());
	}
}
