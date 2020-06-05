package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.PayTypeService;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/pay_type")
public class PayTypeController {
	@Resource
	private PayTypeService payTypeService;
	//新增
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增支付类型")
	public Result add(@ApiParam(value="名称")@RequestParam("name") String name,
			@ApiParam(value="配置")@RequestParam("config") String config,
			@ApiParam(value="描述")@RequestParam("description") String description){
		Result result=payTypeService.addPayType(name, config, description);
		return result;
	}
	//查询所有
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载所有支付类型")
	public Result loadAll(){
		Result result=payTypeService.loadAllPayType();
		return result;
	}
	//根据id查询
	@RequestMapping(value="/{payTypeId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载支付类型信息")
	public Result loadById(@PathVariable("payTypeId") int payTypeId){
		Result result=payTypeService.loadPayTypeById(payTypeId);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{payTypeId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新支付类型信息")
	public Result updateById(@ApiParam(value="支付类型编号")@PathVariable("payTypeId") int payTypeId,
			@ApiParam(value="名称")@RequestParam("name") String name,
			@ApiParam(value="配置")@RequestParam("config") String config,
			@ApiParam(value="描述")@RequestParam("description") String description){
		Result result=payTypeService.updatePayType(payTypeId, name, config, description);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{payTypeId}",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除支付类型信息")
	public Result deleteById(@PathVariable("payTypeId") int payTypeId){
		Result result=payTypeService.deletePayTypeById(payTypeId);
		return result;
	}
			
}
