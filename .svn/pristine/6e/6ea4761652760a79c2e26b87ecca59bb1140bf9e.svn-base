package com.huatec.edu.mobileshop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.huatec.edu.mobileshop.service.GoodsImgService;
import com.huatec.edu.mobileshop.util.MSUtil;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/img")
public class GoodsImgController {
	@Resource
	private GoodsImgService goodsImgService;
	//新增商品图片引用
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增商品图片")
	public Result add(@ApiParam(value="商品编号")@RequestParam("goodsId") int goodsId,
			@ApiParam(value="是否为主图，0：是主图，1：不是主图")@RequestParam("isdefault") int isdefault,
			@ApiParam(value="图片路径")@RequestParam("img") String img,
			HttpServletRequest request){
		String url="http://"+request.getServerName()+":"+request.getLocalPort();
//		String url="http://"+request.getServerName()+":"+request.getLocalPort()
//		+request.getContextPath()+"/upload";
		String path = request.getServletContext().getRealPath("/upload");
		System.out.println("路径"+path);
		Result result=goodsImgService.addImg(goodsId, isdefault, img, url);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{imgId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新商品图片")
	public Result updateById(@ApiParam(value="商品编号")@PathVariable("imgId") int imgId,
			@ApiParam(value="图片路径")@RequestParam("img") String img,
			HttpServletRequest request){
		String url="http://"+request.getServerName()+":"+request.getLocalPort();
		Result result=goodsImgService.updateImg(imgId, img, url);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{imgId}",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除图片")
	public Result deleteById(@PathVariable("imgId") int imgId,HttpServletRequest request){
		String url="http://"+request.getServerName()+":"+request.getLocalPort();
		Result result=goodsImgService.deleteImgById(imgId, url);
		return result;
	}
}
