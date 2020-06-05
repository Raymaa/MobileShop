package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.ShipService;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/ship")
public class ShipController {
	@Resource
	private ShipService shipService;
	//新增货运公司
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增货运公司")
	public Result add(@ApiParam(value="名称")@RequestParam("name") String name,
			@ApiParam(value="代码")@RequestParam("code") String code){
		Result result=shipService.addShip(name, code);
		return result;
	}
	//查询所有
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载所有货运公司")
	public Result loadAll(){
		Result result=shipService.loadAllShip();
		return result;
	}
	//根据id查询
	@RequestMapping(value="/{shipId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载货运公司信息")
	public Result loadById(@PathVariable("shipId") int shipId){
		Result result=shipService.loadShipById(shipId);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{shipId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新货运公司信息")
	public Result updateById(@ApiParam(value="货运公司编号")@PathVariable("shipId") int shipId,
			@ApiParam(value="名称")@RequestParam("name") String name,
			@ApiParam(value="代码")@RequestParam("code") String code){
		Result result=shipService.updateShip(shipId, name, code);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{shipId}",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除货运公司信息")
	public Result deleteById(@PathVariable("shipId") int shipId){
		Result result=shipService.deleteShipById(shipId);
		return result;
	}
			
}
