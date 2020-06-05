package com.huatec.edu.mobileshop.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.GoodsTypeService;
import com.huatec.edu.mobileshop.util.Result;

@Controller
@RequestMapping("/type")
public class GoodsTypeController {
	@Resource
	private GoodsTypeService goodsTypeService;
	//新增商品类型
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Result add(String name, String param1, String param2, String param3, 
			String param4, String param5,int isPhysical){
		String[] paramsKey=new String[]{param1,param2,param3,param4,param5};
		Result result=goodsTypeService.addType(name, paramsKey, isPhysical);
		return result;
	}
	//加载所有商品类型
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Result loadAll(){
		Result result=goodsTypeService.loadAllTypes();
		return result;
	}
	//根据id加载商品类型
	@RequestMapping(value="/{typeId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadById(@PathVariable("typeId") int typeId){
		Result result=goodsTypeService.loadTypeById(typeId);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{typeId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateById(@PathVariable("typeId") int typeId,String name, String param1, 
			String param2, String param3, String param4, String param5, int isPhysical){
		String[] paramsKey=new String[]{param1,param2,param3,param4,param5};
		Result result=goodsTypeService.updateType(typeId, name, paramsKey, isPhysical);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{typeId}",method=RequestMethod.DELETE)
	@ResponseBody
	public Result deleteById(@PathVariable("typeId") int typeId){
		Result result=goodsTypeService.deleteTypeById(typeId);
		return result;
	}
	//根据id更新是否可用
	@RequestMapping(value="/disabled/{typeId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateDisabled(@PathVariable("typeId") int typeId,int disabled){
		Result result=goodsTypeService.updateDisabled(typeId, disabled);
		return result;
	}
	//加载所有可用的类型
	@RequestMapping(value="/disabled",method=RequestMethod.GET)
	@ResponseBody
	public Result loadByDisabled(){
		Result result=goodsTypeService.loadTypeByDisabled();
		return result;
	}
}
