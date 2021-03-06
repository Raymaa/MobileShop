package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.GoodsLikeService;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/like")
public class GoodsLikeController {
	@Resource
	private GoodsLikeService goodsLikeService;
	//新增商品收藏信息
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="收藏商品")
	public Result add(@ApiParam(value="商品编号")@RequestParam("goodsId") int goodsId,
			@ApiParam(value="会员编号")@RequestParam("memberId") int memberId){
		Result result=goodsLikeService.add(goodsId, memberId);
		return result;
	}
	//根据会员id加载收藏的商品
	@RequestMapping(value="/member/{memberId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据会员编号加载收藏的商品")
	public Result loadByMemberId(@PathVariable("memberId") int memberId){
		Result result=goodsLikeService.loadByMemberId(memberId);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{likeId}",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="取消收藏")
	public Result deleteById(@PathVariable("likeId") int likeId){
		Result result=goodsLikeService.deleteById(likeId);
		return result;
	}
}
