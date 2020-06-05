package com.huatec.edu.mobileshop.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.GoodsLikeDao;
import com.huatec.edu.mobileshop.entity.GoodsLike;

public class TestGoodsLikeDao {
	//获取GoodsLikeDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	GoodsLikeDao goodsLikeDao=ac.getBean("goodsLikeDao",GoodsLikeDao.class);
	
	@Test
	public void test2(){
		List<GoodsLike> gls=goodsLikeDao.findUnionByMemberId(16);
		System.out.println(gls.size());
		for(GoodsLike gl:gls){
			System.out.println(gl);
		}
	}
	@Test
	public void test1(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("goods_id", 20);
		map.put("member_id", 16);
		GoodsLike gl=goodsLikeDao.findRepeat(map);
		System.out.println(gl);
	}
}
