package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.CartService;
import com.huatec.edu.mobileshop.util.Result;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Resource
	private CartService cartService;
	//新增
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Result add(int memberId,int goodsId,int goodsNum){
		Result result=cartService.addCart(memberId, goodsId, goodsNum);
		return result;
	}
	//根据会员id加载
	@RequestMapping(value="/member/{memberId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadByMemberId(@PathVariable("memberId") int memberId){
		Result result=cartService.loadCartByMemberId(memberId);
		return result;
	}
	//根据会员id加载选中的商品
	@RequestMapping(value="/choose/member/{memberId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadChooseByMemberId(@PathVariable("memberId") int memberId){
		Result result=cartService.loadChooseCartByMemberId(memberId);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{cartId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateById(@PathVariable("cartId") int cartId,int goodsNum,int choose){
		Result result=cartService.updateCart(cartId, goodsNum, choose);
		return result;
	}
	//根据id更新商品数量
	@RequestMapping(value="/num/{cartId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateGoodsNum(@PathVariable("cartId") int cartId,int goodsNum){
		Result result=cartService.updateGoodsNum(cartId, goodsNum);
		return result;
	}
	//根据id更新状态
	@RequestMapping(value="/choose/{cartId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateChoose(@PathVariable("cartId") int cartId,int choose){
		Result result=cartService.updateChoose(cartId, choose);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{cartId}",method=RequestMethod.DELETE)
	@ResponseBody
	public Result deleteById(@PathVariable("cartId") int cartId){
		Result result=cartService.deleteCartById(cartId);
		return result;
	}
}
