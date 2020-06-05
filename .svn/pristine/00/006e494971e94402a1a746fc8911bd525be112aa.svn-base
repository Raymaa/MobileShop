package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.GoodsCommentService;
import com.huatec.edu.mobileshop.util.Result;

@Controller
@RequestMapping("/comment")
public class GoodsCommentController {
	@Resource
	private GoodsCommentService goodsCommentService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Result add(int orderId,int goodsId,int score,String content,int isopen){
		Result result=goodsCommentService.addComment(orderId, goodsId, score, content, isopen);
		return result;
	}
	@RequestMapping(value="/goods/{goodsId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadByGoodsId(@PathVariable("goodsId") int goodsId){
		Result result=goodsCommentService.loadCommentByGoodsId(goodsId);
		return result;
	}
	@RequestMapping(value="/member/{memberId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadByMemberId(@PathVariable("memberId") int memberId){
		Result result=goodsCommentService.loadCommentByMemberId(memberId);
		return result;
	}
}
