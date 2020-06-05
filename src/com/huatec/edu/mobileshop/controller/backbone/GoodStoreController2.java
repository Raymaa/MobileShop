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

import com.huatec.edu.mobileshop.service.GoodStoreService;
import com.huatec.edu.mobileshop.util.MSUtil;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/backbone/store")
public class GoodStoreController2 {
	@Resource
	private GoodStoreService goodStoreService;
	//新增商品库存
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增商品库存")
	public Result add(HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		int goodsId=Integer.parseInt((String) jmap.get("goodsId"));
		int store=Integer.parseInt((String) jmap.get("store"));
		Result result=goodStoreService.addStore(goodsId, store);
		return result;
	}
	//查询所有库存（关联查询+分页）
	@RequestMapping(value="/page/{pageId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载所有库存")
	public Result loadAllByPage(@PathVariable("pageId") int pageId){
		Result result=goodStoreService.loadAllStore(pageId);
		return result;
	}
	//根据id更新库存
	@RequestMapping(value="/{storeId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新库存")
	public Result update(@ApiParam(value="库存编号")@PathVariable("storeId") int storeId,
			HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		int store=Integer.parseInt((String) jmap.get("store"));
		Result result=goodStoreService.updateStore(storeId, store);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{storeId}",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除库存")
	public Result deleteById(@PathVariable("storeId") int storeId){
		Result result=goodStoreService.deleteStoreById(storeId);
		return result;
	}
	
}
