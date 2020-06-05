package com.huatec.edu.mobileshop.controller.backbone;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.OrderService;
import com.huatec.edu.mobileshop.util.MSUtil;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/backbone/order")
public class OrderController2 {
	@Resource
	private OrderService orderService;
	//新增
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增订单")
	public Result add(HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		int memberId=Integer.parseInt((String) jmap.get("memberId"));
        int addressId=Integer.parseInt((String) jmap.get("addressId"));
        int paytypeId=Integer.parseInt((String) jmap.get("paytypeId"));
        int carriage=Integer.parseInt((String) jmap.get("carriage"));
		Result result=orderService.addOrder(memberId, addressId,paytypeId,carriage);
		return result;
	}
	//根据id加载
	@RequestMapping(value="/{orderId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载订单信息")
	public Result loadById(@PathVariable("orderId") int orderId){
		Result result=orderService.loadOrderById(orderId);
		return result;
	}
	//根据会员id加载（订单表、订单商品表、商品表关联查询）
	@RequestMapping(value="/member/{memberId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="订单详情")
	public Result loadByMemberId(@PathVariable("memberId") int memberId){
		Result result=orderService.loadOrderByMemberId(memberId);
		return result;
	}
	//加载所有订单（分页）
	@RequestMapping(value="/page/{pageId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载所有订单（分页）")
	public Result loadAll(@PathVariable("pageId") int pageId){
		Result result=orderService.loadAllOrderByPage(pageId);
		return result;
	}
	//根据状态加载订单（待付款、待发货,分页）
	@RequestMapping(value="/status/{status}/{pageId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据状态加载订单（待付款、待发货,分页）")
	public Result loadByStatus(@PathVariable("status") int status,
			@PathVariable("pageId") int pageId){
		Result result=orderService.loadOrderByStatus(status, pageId);
		return result;
	}
	//更新订单状态（取消订单）
	@RequestMapping(value="/{orderId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="取消订单（更新订单状态）")
	public Result updateStatusById(@PathVariable("orderId") int orderId){
		Result result=orderService.updateOrderStatus(orderId);
		return result;
	}
}
