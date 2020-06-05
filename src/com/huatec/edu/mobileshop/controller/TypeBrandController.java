package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.TypeBrandService;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/type_brand")
public class TypeBrandController {
	@Resource
	private TypeBrandService typeBrandService;
	//新增
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增类型品牌关联信息")
	public Result add(@ApiParam(value="类型编号")@RequestParam("typeId") int typeId,
			@ApiParam(value="品牌编号")@RequestParam("brandId") int brandId){
		Result result=typeBrandService.add(typeId, brandId);
		return result;
	}
	//加载所有（关联查询）
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载所有")
	public Result loadAll(){
		Result result=typeBrandService.loadAll();
		return result;
	}
	//根据id加载（关联查询）
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据id加载（关联查询）")
	public Result loadById(@PathVariable("id") int id){
		Result result=typeBrandService.loadById(id);
		return result;
	}
	//根据类型id加载（关联查询）
	@RequestMapping(value="/type/{typeId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据类型id加载（关联查询）")
	public Result loadByTypeId(@PathVariable("typeId") int typeId){
		Result result=typeBrandService.loadByTypeId(typeId);
		return result;
	}
	//根据品牌id加载（关联查询）
	@RequestMapping(value="/brand/{brandId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据品牌id加载（关联查询）")
	public Result loadByBrandId(@PathVariable("brandId") int brandId){
		Result result=typeBrandService.loadByBrandId(brandId);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="根据id更新")
	public Result updateById(@ApiParam(value="编号")@PathVariable("id") int id,
			@ApiParam(value="类型编号")@RequestParam("typeId") int typeId,
			@ApiParam(value="品牌编号")@RequestParam("brandId") int brandId){
		Result result=typeBrandService.update(id, typeId, brandId);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="根据id删除")
	public Result deleteById(@PathVariable("id") int id){
		Result result=typeBrandService.deleteById(id);
		return result;
	}
	
	//根据品牌id加载（关联查询）
	@RequestMapping(value="/cat/{catId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据分类id加载（关联查询）")
	public Result loadByCatId(@PathVariable("catId") int catId){
		Result result=typeBrandService.loadByCatId(catId);
		return result;
	}
}
