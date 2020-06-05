package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.BrandService;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/brand")
public class BrandController {
	@Resource
	private BrandService brandService;
	//新增品牌
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增品牌")
	public Result add(@ApiParam(value="品牌名称")@RequestParam("name") String name, 
			@ApiParam(value="品牌logo")@RequestParam("logo") String logo, 
			@ApiParam(value="品牌关键字")@RequestParam("keywords") String keywords, 
			@ApiParam(value="品牌描述")@RequestParam("description") String description, 
			@ApiParam(value="品牌链接")@RequestParam("url") String url){
		Result result=brandService.addBrand(name, logo, keywords, description, url);
		return result;
	}
	//加载所有品牌(分页)
	@RequestMapping(value="/page/{pageId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载所有品牌（分页）")
	public Result loadAllByPage(@PathVariable("pageId") int pageId){
		Result result=brandService.loadAllBrandsByPage(pageId);
		return result;
	}
	//根据id加载品牌
	@RequestMapping(value="/{brandId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载品牌信息")
	public Result loadById(@PathVariable("brandId") int brandId){
		Result result=brandService.loadBrandById(brandId);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{brandId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新品牌信息")
	public Result updateById(@ApiParam(value="品牌编号")@PathVariable("brandId") int brandId,
			@ApiParam(value="品牌名称")@RequestParam("name") String name,
			@ApiParam(value="品牌logo")@RequestParam("logo") String logo,
			@ApiParam(value="品牌关键字")@RequestParam("keywords") String keywords,
			@ApiParam(value="品牌描述")@RequestParam("description") String description,
			@ApiParam(value="品牌链接")@RequestParam("url") String url){
		Result result=brandService.updateBrand(brandId, name, logo, keywords, 
				description, url);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{brandId}",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除品牌")
	public Result deleteById(@PathVariable("brandId") int brandId){
		Result result=brandService.deleteBrandById(brandId);
		return result;
	}
	//根据id更新是否可用
	@RequestMapping(value="/disabled/{brandId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新品牌状态（是否可用）")
	public Result updateDisabled(@ApiParam(value="品牌编号")@PathVariable("brandId") int brandId,
			@ApiParam(value="状态，0：可用，1：不可用")@RequestParam("disabled") int disabled){
		Result result=brandService.updateDisabled(brandId, disabled);
		return result;
	}
	//加载所有可用的品牌
	@RequestMapping(value="/disabled",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载所有可用的品牌")
	public Result loadByDisabled(){
		Result result=brandService.loadBrandByDisabled();
		return result;
	}
}
