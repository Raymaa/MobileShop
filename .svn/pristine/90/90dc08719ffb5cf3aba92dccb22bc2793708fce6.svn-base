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

import com.huatec.edu.mobileshop.service.CartService;
import com.huatec.edu.mobileshop.util.MSUtil;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/backbone/cart")
public class CartController2 {
	@Resource
	private CartService cartService;
	//新增
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="添加商品至购物车")
	public Result add(HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		int memberId=Integer.parseInt((String) jmap.get("memberId"));
		int goodsId=Integer.parseInt((String) jmap.get("goodsId"));
		int goodsNum=Integer.parseInt((String) jmap.get("goodsNum"));
		Result result=cartService.addCart(memberId, goodsId, goodsNum);
		return result;
	}
	//根据会员id加载
	@RequestMapping(value="/member/{memberId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据会员id加载购物车信息")
	public Result loadByMemberId(@PathVariable("memberId") int memberId){
		Result result=cartService.loadCartByMemberId(memberId);
		return result;
	}
	//根据会员id加载选中的商品
	@RequestMapping(value="/choose/member/{memberId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据会员id加载选中的商品")
	public Result loadChooseByMemberId(@PathVariable("memberId") int memberId){
		Result result=cartService.loadChooseCartByMemberId(memberId);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{cartId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新购物车信息")
	public Result updateById(@ApiParam(value="编号")@PathVariable("cartId") int cartId,
			HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		int goodsNum=Integer.parseInt((String) jmap.get("goodsNum"));
		int choose=Integer.parseInt((String) jmap.get("choose"));
		Result result=cartService.updateCart(cartId, goodsNum, choose);
		return result;
	}
	//根据id更新商品数量
	@RequestMapping(value="/num/{cartId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新商品数量")
	public Result updateGoodsNum(@ApiParam(value="编号")@PathVariable("cartId") int cartId,
			HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		int goodsNum=Integer.parseInt((String) jmap.get("goodsNum"));
		Result result=cartService.updateGoodsNum(cartId, goodsNum);
		return result;
	}
	//根据id更新状态
	@RequestMapping(value="/choose/{cartId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新购物车状态")
	public Result updateChoose(@ApiParam(value="编号")@PathVariable("cartId") int cartId,
			HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		int choose=Integer.parseInt((String) jmap.get("choose"));
		Result result=cartService.updateChoose(cartId, choose);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{cartId}",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除购物车信息（一条）")
	public Result deleteById(@PathVariable("cartId") int cartId){
		Result result=cartService.deleteCartById(cartId);
		return result;
	}
}
