package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.GoodsCatDao;
import com.huatec.edu.mobileshop.entity.GoodsCat;

public class TestGoodsCatDao {
	//获取GoodsCatDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	GoodsCatDao goodsCatDao=ac.getBean("goodsCatDao",GoodsCatDao.class);
	
	@Test
	public void test10(){
		GoodsCat gc=goodsCatDao.findUnionById(2);
		System.out.println(gc);
	}
	@Test
	public void test9(){
		List<GoodsCat> gcs=goodsCatDao.findUnionByParentId(0);
		for(GoodsCat gc:gcs){
			System.out.println(gc);
		}
	}
	@Test
	public void test8(){
		GoodsCat goodsCat=new GoodsCat();
		goodsCat.setParent_id(1);
		goodsCat.setList_show(0);
		List<GoodsCat> gcs=goodsCatDao.dynamicFind(goodsCat);
		for(GoodsCat gc:gcs){
			System.out.println(gc);
		}
	}
	/*@Test
	public void test7(){
		List<GoodsCat> gcs=goodsCatDao.findByParentId(0);
		for(GoodsCat gc:gcs){
			System.out.println(gc);
		}
	}*/
	/*@Test
	public void test6(){
		List<GoodsCat> gcs=goodsCatDao.findByCatPath(3);
		for(GoodsCat gc:gcs){
			System.out.println(gc);
		}
	}*/
	@Test
	public void test5(){
		GoodsCat gc=goodsCatDao.findByName("饮料");
		System.out.println(gc);
	}
	@Test
	public void test4(){
		List<GoodsCat> gcs=goodsCatDao.findByParentIdDESC(1);
		System.out.println("length:"+gcs.get(0).getCat_path().split(",").length);
		for(GoodsCat gc:gcs){
			System.out.println(gc);
		}
	}
	@Test
	public void test3(){
		List<GoodsCat> gcs=goodsCatDao.findByCatPathDESC(3);
		System.out.println("1:"+gcs.get(0).getCat_path());
		String path=gcs.get(0).getCat_path();
		System.out.println("2:"+path.split(",")[0]);
		for(GoodsCat gc:gcs){
			System.out.println(gc);
		}
	}
	@Test
	public void test2(){
		List<GoodsCat> gcs=goodsCatDao.findByTypeId(4);
		for(GoodsCat gc:gcs){
			System.out.println(gc);
		}
	}
	@Test
	public void test1(){
		GoodsCat gc=new GoodsCat();
		gc.setCat_id(null);
		gc.setName("酒水");
		gc.setParent_id(0);
		gc.setCat_path("0,2");
		gc.setGoods_count(0);
		gc.setSort(0);
		gc.setType_id(5);
		gc.setList_show(0);
		gc.setImage("");
		gc.setCreatime(null);
		gc.setModifytime(null);
		goodsCatDao.save(gc);
	}
}
