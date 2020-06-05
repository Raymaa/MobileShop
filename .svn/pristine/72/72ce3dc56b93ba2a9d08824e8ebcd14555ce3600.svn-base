package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.Ship;
import com.huatec.edu.mobileshop.service.ShipService;
import com.huatec.edu.mobileshop.util.Result;

public class TestShipService {
	//获取ShipService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	ShipService shipService=ac.getBean("shipServiceImpl",ShipService.class);
	
	@Test
	public void test5(){
		Result result=shipService.deleteShipById(1);
		System.out.println(result.getMsg());
	}
	@Test
	public void test4(){
		Result result=shipService.updateShip(2, "申通快递", "shentong");
		System.out.println(result.getMsg());
	}
	@Test
	public void test3(){
		Result result=shipService.loadShipById(7);
		System.out.println(result.getMsg());
		Ship ship=(Ship) result.getData();
		System.out.println(ship);
	}
	@Test
	public void test2(){
		Result result=shipService.loadAllShip();
		System.out.println(result.getMsg());
		List<Ship> ships=(List<Ship>) result.getData();
		for(Ship s:ships){
			System.out.println(s);
		}
	}
	@Test
	public void test1(){
		Result result=shipService.addShip("顺丰速运", "sfsy");
		System.out.println(result.getMsg());
	}
}
