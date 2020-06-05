package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.GoodsCatService;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/cat")
public class GoodsCatController {
	@Resource
	private GoodsCatService goodsCatService;
	
	//新增分类
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增商品分类")
	public Result add(@ApiParam(value="商品分类名称")@RequestParam("name") String name,
			@ApiParam(value="父分类编号，没有父分类为0")@RequestParam("parentId") int parentId,
			@ApiParam(value="类型编号")@RequestParam("typeId") int typeId){
		Result result=goodsCatService.addCat(name, parentId, typeId);
		return result;
	}
	//加载顶级分类（和类型表关联查询）
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载顶级分类")
	public Result loadTop(){
		Result result=goodsCatService.loadTopCat();
		return result;
	}
	//根据父id加载二级分类（和类型表关联查询）
	@RequestMapping(value="/parent/{parentId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载二级分类")
	public Result loadByParentId(@PathVariable("parentId") int parentId){
		Result result=goodsCatService.loadCatByParentId(parentId);
		return result;
	}
	//加载”可显示到列表“的顶级分类
	@RequestMapping(value="/show",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载可用的顶级分类")
	public Result loadShowTop(){
		Result result=goodsCatService.loadShowTopCat();
		return result;
	}
	//根据父id加载”可显示到列表“的二级分类
	@RequestMapping(value="/show/{parentId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载可用的二级分类")
	public Result loadShowByParentId(@PathVariable("parentId") int parentId){
		Result result=goodsCatService.loadShowCatByParentId(parentId);
		return result;
	}
	//根据id加载分类
	@RequestMapping(value="/{catId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载商品分类信息")
	public Result loadById(@PathVariable("catId") int catId){
		Result result=goodsCatService.loadCatById(catId);
		return result;
	}
	//根据id加载分类（关联查询）
	@RequestMapping(value="/union/{catId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载商品分类信息（关联查询）")
	public Result loadUnionById(@PathVariable("catId") int catId){
		Result result=goodsCatService.loadUnionCatById(catId);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{catId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新商品分类信息")
	public Result updateById(@ApiParam(value="商品分类编号")@PathVariable("catId") int catId,
			@ApiParam(value="分类名称")@RequestParam("name") String name,
			@ApiParam(value="显示次序,0：不排序")@RequestParam("sort") int sort,
			@ApiParam(value="类型编号")@RequestParam("typeId") int typeId,
			@ApiParam(value="是否显示到列表，0：显示，1：不显示")@RequestParam("list_show") int list_show,
			@ApiParam(value="分类图片")@RequestParam("image") String image){
		Result result=goodsCatService.updateCat(catId, name, sort, 
				typeId, list_show, image);
		return result;
	}
	//根据id更新image（设置图片）
	@RequestMapping(value="/image/{catId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新商品分类图片")
	public Result updateImage(@PathVariable("catId") int catId,String img,
			HttpServletRequest request){
		System.out.println("img:"+img);
		String url="http://"+request.getServerName()+":"+request.getLocalPort();
		Result result=goodsCatService.updateImage(catId, img, url);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{catId}",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除商品分类信息")
	public Result deleteById(@PathVariable("catId") int catId){
		Result result=goodsCatService.deleteCatById(catId);
		return result;
	}
}
