package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.dao.ShipDao;
import com.huatec.edu.mobileshop.entity.Ship;

public class TestShipDao {
	//获取ShipDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	ShipDao shipDao=ac.getBean("shipDao",ShipDao.class);
	
	@Test
	public void test6(){
		Ship ship=new Ship();
		ship.setName("天天快递");
		Ship s=shipDao.dynamicFind(ship);
		System.out.println(s);
	}
	@Test
	public void test5(){
		Ship ship=new Ship();
		ship.setShip_id(5);
		ship.setName("天天快递");
		ship.setCode("ttkd");
		shipDao.dynamicUpdate(ship);
	}
	@Test
	public void test4(){
		shipDao.deleteById(4);
	}
	@Test
	public void test3(){
		Ship s=shipDao.findById(1);
		System.out.println(s);
	}
	@Test
	public void test2(){
		List<Ship> ss=shipDao.findAll();
		for(Ship s:ss){
			System.out.println(s);
		}
	}
	@Test
	public void test1(){
		Ship ship=new Ship();
		ship.setShip_id(null);
		ship.setName("天天快递");
		ship.setCode("tiantian");
		ship.setCreatime(null);
		ship.setModifytime(null);
		shipDao.save(ship);
		System.out.println(ship.getShip_id());
	}
}
