package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.PaymentService;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	@Resource
	private PaymentService paymentService;
	//更新支付状态（付款，改变状态）
	@RequestMapping(value="/{orderId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="付款（更新支付状态）")
	public Result update(@PathVariable("orderId") int orderId){
		Result result=paymentService.updatePayment(orderId);
		return result;
	}
}
