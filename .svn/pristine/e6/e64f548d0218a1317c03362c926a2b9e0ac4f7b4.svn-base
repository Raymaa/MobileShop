package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.GoodStoreService;
import com.huatec.edu.mobileshop.util.Result;

@Controller
@RequestMapping("/store")
public class GoodStoreController {
	@Resource
	private GoodStoreService goodStoreService;
	//新增商品库存
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Result add(int goodsId,int store){
		Result result=goodStoreService.addStore(goodsId, store);
		return result;
	}
	//查询所有库存（关联查询+分页）
	@RequestMapping(value="/page/{pageId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadAllByPage(@PathVariable("pageId") int pageId){
		Result result=goodStoreService.loadAllStore(pageId);
		return result;
	}
	//根据id更新库存
	@RequestMapping(value="/{storeId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result update(@PathVariable("storeId") int storeId,int store){
		Result result=goodStoreService.updateStore(storeId, store);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{storeId}",method=RequestMethod.DELETE)
	@ResponseBody
	public Result deleteById(@PathVariable("storeId") int storeId){
		Result result=goodStoreService.deleteStoreById(storeId);
		return result;
	}
	
}
