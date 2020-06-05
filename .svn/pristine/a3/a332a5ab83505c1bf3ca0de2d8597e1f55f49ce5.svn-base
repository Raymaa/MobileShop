package com.huatec.edu.mobileshop.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.Goods;
import com.huatec.edu.mobileshop.entity.brief.BriefGoods;
import com.huatec.edu.mobileshop.service.GoodsService;
import com.huatec.edu.mobileshop.util.Result;

import net.sf.json.JSONObject;

public class TestGoodsService {
	//获取GoodsDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	GoodsService goodsService=ac.getBean("goodsServiceImpl",GoodsService.class);
	
	@Test
	public void test13(){
		String[] paramsValue=new String[]{"黑龙江","20g","6个月","橘子味",""};
		Result result=goodsService.updateParams(32, paramsValue);
		System.out.println(result.getMsg());
	}
	@Test
	public void test12(){
		String s="{'参数':{'产地':'','净含量':'','保质期':'','口味':''}}";
		//String转json
		JSONObject js=JSONObject.fromObject(s);
		//json转map
		Map<String,Object> map=(Map)js;
		System.out.println(map);
		System.out.println(map.get("参数"));
		JSONObject jParams=JSONObject.fromObject(map.get("参数"));
		Map map1=(Map)jParams;
		Set<String> keySet=map1.keySet();
		Iterator it=keySet.iterator();
		String value1="黑龙江";
		String value2="20g";
		String value3="6个月";
		String value4="橘子味";
		String value5="123";
		String[] str=new String[]{value1,value2,value3,value4,value5};
		for(int i=0;i<=4;i++){
			if(it.hasNext()){
				map1.put(it.next(), str[i]);
			}
		}
		System.out.println(map1);
		map.put("参数", map1);
		String strMap=map.toString();
		System.out.println(map);
		System.out.println(strMap);
	}
	@Test
	public void test11(){
		Result result=goodsService.updateEnable(21, 1);
		System.out.println(result.getMsg());
	}
	@Test
	public void test10(){
		Result result=goodsService.loadAllEnableGoodsByPage(1);
		System.out.println(result.getMsg());
		List<BriefGoods> bgs=(List<BriefGoods>)result.getData();
		for(BriefGoods bg:bgs){
			System.out.println(bg);
		}
	}
	@Test
	public void test9(){
		Result result=goodsService.deleteGoodsById(10);
		System.out.println(result.getMsg());
	}
	@Test
	public void test8(){
		Result result=goodsService.updateGoods(8, "测试茶饮料001", "cscyl001", 
				"test", "testcyl001", 9.9, 6.6, 11.00, 0, 4, 5, 250, "", "", "");
		System.out.println(result.getMsg());
	}
	@Test
	public void test7(){
		Result result=goodsService.searchGoods("test");
		System.out.println(result.getMsg());
		List<BriefGoods> bgs=(List<BriefGoods>)result.getData();
		for(BriefGoods bg:bgs){
			System.out.println(bg);
		}
	}
	@Test
	public void test6(){
		Result result=goodsService.loadGoodsByBrandId(6);
		System.out.println(result.getMsg());
		List<BriefGoods> bgs=(List<BriefGoods>) result.getData();
		for(BriefGoods bg:bgs){
			System.out.println(bg);
		}
	}
	@Test
	public void test5(){
		Result result=goodsService.loadGoodsByCatId(1);
		System.out.println(result.getMsg());
		List<BriefGoods> bgs=(List<BriefGoods>) result.getData();
		if(bgs!=null){
			for(BriefGoods bg:bgs){
				System.out.println(bg);
			}
		}
	}
	@Test
	public void test4(){
		Result result=goodsService.loadGoodsByIdUnion(31);
		System.out.println(result.getMsg());
		Goods g=(Goods) result.getData();
		System.out.println(g);
	}
	@Test
	public void test3(){
		Result result=goodsService.loadGoodsById(2);
		System.out.println(result.getMsg());
		Goods g=(Goods) result.getData();
		System.out.println(g);
	}
	@Test
	public void test2(){
		Result result=goodsService.loadAllGoodsByPage(1);
		System.out.println(result.getMsg());
		List<BriefGoods> bgs=(List<BriefGoods>) result.getData();
		if(bgs!=null){
			for(BriefGoods bg:bgs){
				System.out.println(bg);
			}
		}
	}
	@Test
	public void test1(){
		Result result=goodsService.addGoods("测试茶饮料017", "testcyl016", "test", "testcyl016", 
				9.9, 6.6, 12.00, 23, 5, 250, "");
		System.out.println(result.getMsg());
	}
}
