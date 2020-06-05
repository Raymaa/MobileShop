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

@Controller
@RequestMapping("/img")
public class GoodsImgController {
	@Resource
	private GoodsImgService goodsImgService;
	//新增商品图片引用
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Result upload(int goodsId,int isdefault,String img,HttpServletRequest request){
		String url="http://"+request.getServerName()+":"+request.getLocalPort();
		Result result=goodsImgService.addImg(goodsId, isdefault, img, url);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{imgId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateById(@PathVariable("imgId") int imgId,String img,
			HttpServletRequest request){
		String url="http://"+request.getServerName()+":"+request.getLocalPort();
		Result result=goodsImgService.updateImg(imgId, img, url);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{imgId}",method=RequestMethod.DELETE)
	@ResponseBody
	public Result deleteById(@PathVariable("imgId") int imgId,HttpServletRequest request){
		String url="http://"+request.getServerName()+":"+request.getLocalPort();
		Result result=goodsImgService.deleteImgById(imgId, url);
		return result;
	}
}
