package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.GoodsCatService;
import com.huatec.edu.mobileshop.util.Result;

@Controller
@RequestMapping("/cat")
public class GoodsCatController {
	@Resource
	private GoodsCatService goodsCatService;
	
	//新增分类
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Result add(String name,int parentId,int typeId){
		Result result=goodsCatService.addCat(name, parentId, typeId);
		return result;
	}
	//加载顶级分类（和类型表关联查询）
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Result loadTop(){
		Result result=goodsCatService.loadTopCat();
		return result;
	}
	//根据父id加载二级分类（和类型表关联查询）
	@RequestMapping(value="/parent/{parentId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadByParentId(@PathVariable("parentId") int parentId){
		Result result=goodsCatService.loadCatByParentId(parentId);
		return result;
	}
	//加载”可显示到列表“的顶级分类
	@RequestMapping(value="/show",method=RequestMethod.GET)
	@ResponseBody
	public Result loadShowTop(){
		Result result=goodsCatService.loadShowTopCat();
		return result;
	}
	//根据父id加载”可显示到列表“的二级分类
	@RequestMapping(value="/show/{parentId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadShowByParentId(@PathVariable("parentId") int parentId){
		Result result=goodsCatService.loadShowCatByParentId(parentId);
		return result;
	}
	//根据id加载分类
	@RequestMapping(value="/{catId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadById(@PathVariable("catId") int catId){
		Result result=goodsCatService.loadCatById(catId);
		return result;
	}
	//根据id加载分类（关联查询）
	@RequestMapping(value="/union/{catId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadUnionById(@PathVariable("catId") int catId){
		Result result=goodsCatService.loadUnionCatById(catId);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{catId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateById(@PathVariable("catId") int catId,String name,int sort,
			int typeId,int list_show,String image){
		Result result=goodsCatService.updateCat(catId, name, sort, 
				typeId, list_show, image);
		return result;
	}
	//根据id更新image（设置图片）
	@RequestMapping(value="/image/{catId}",method=RequestMethod.PUT)
	@ResponseBody
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
	public Result deleteById(@PathVariable("catId") int catId){
		Result result=goodsCatService.deleteCatById(catId);
		return result;
	}
}
