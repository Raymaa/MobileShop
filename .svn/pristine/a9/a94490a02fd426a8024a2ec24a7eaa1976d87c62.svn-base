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

import com.huatec.edu.mobileshop.service.GoodsCommentService;
import com.huatec.edu.mobileshop.util.MSUtil;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/backbone/comment")
public class GoodsCommentController2 {
	@Resource
	private GoodsCommentService goodsCommentService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增商品评论")
	public Result add(HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		int orderId=Integer.parseInt((String) jmap.get("orderId"));
		int goodsId=Integer.parseInt((String) jmap.get("goodsId"));
		int score=Integer.parseInt((String) jmap.get("score"));
		String content=(String) jmap.get("content");
		int isopen=Integer.parseInt((String) jmap.get("isopen"));
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
