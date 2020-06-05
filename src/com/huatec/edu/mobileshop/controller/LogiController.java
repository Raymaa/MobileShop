package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.LogiService;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/logi")
public class LogiController {
	@Resource
	private LogiService logiService;
	//更新物流（发货,更新状态）
	@RequestMapping(value="/{orderId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="发货（更新状态）")
	public Result update(@ApiParam(value="订单编号")@PathVariable("orderId") int orderId,
			@ApiParam(value="货运公司编号")@RequestParam("shipId") int shipId,
			@ApiParam(value="运单号")@RequestParam("sn") String sn,
			@ApiParam(value="发货人")@RequestParam("sender") String sender){
		Result result=logiService.updateLogi(orderId, shipId, sn, sender);
		return result;
	}
	//更新物流状态（确认收货）
	@RequestMapping(value="/status/{orderId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="确认收货（更新状态）")
	public Result updateStatus(@PathVariable("orderId") int orderId){
		Result result=logiService.updateLogiStatus(orderId);
		return result;
	}
}
