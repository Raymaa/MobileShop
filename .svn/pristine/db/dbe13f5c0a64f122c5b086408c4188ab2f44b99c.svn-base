package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.ShipService;
import com.huatec.edu.mobileshop.util.Result;

@Controller
@RequestMapping("/ship")
public class ShipController {
	@Resource
	private ShipService shipService;
	//新增货运公司
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Result add(String name,String code){
		Result result=shipService.addShip(name, code);
		return result;
	}
	//查询所有
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Result loadAll(){
		Result result=shipService.loadAllShip();
		return result;
	}
	//根据id查询
	@RequestMapping(value="/{shipId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadById(@PathVariable("shipId") int shipId){
		Result result=shipService.loadShipById(shipId);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{shipId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateById(@PathVariable("shipId") int shipId,String name,String code){
		Result result=shipService.updateShip(shipId, name, code);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{shipId}",method=RequestMethod.DELETE)
	@ResponseBody
	public Result deleteById(@PathVariable("shipId") int shipId){
		Result result=shipService.deleteShipById(shipId);
		return result;
	}
			
}
