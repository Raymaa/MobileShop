package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.GoodsCommentService;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/comment")
public class GoodsCommentController {
	@Resource
	private GoodsCommentService goodsCommentService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增商品评论")
	public Result add(@ApiParam(value="订单编号")@RequestParam("orderId") int orderId,
			@ApiParam(value="商品编号")@RequestParam("goodsId") int goodsId,
			@ApiParam(value="分数，5分制")@RequestParam("score") int score,
			@ApiParam(value="评论")@RequestParam("content") String content,
			@ApiParam(value="是否公开，0：公开，1：匿名")@RequestParam("isopen") int isopen){
		Result result=goodsCommentService.addComment(orderId, goodsId, score, content, isopen);
		return result;
	}
	@RequestMapping(value="/goods/{goodsId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据商品编号加载评论")
	public Result loadByGoodsId(@PathVariable("goodsId") int goodsId){
		Result result=goodsCommentService.loadCommentByGoodsId(goodsId);
		return result;
	}
	@RequestMapping(value="/member/{memberId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据会员编号加载评论")
	public Result loadByMemberId(@PathVariable("memberId") int memberId){
		Result result=goodsCommentService.loadCommentByMemberId(memberId);
		return result;
	}
}
