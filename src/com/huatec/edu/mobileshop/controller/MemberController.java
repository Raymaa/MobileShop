package com.huatec.edu.mobileshop.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.MemberService;
import com.huatec.edu.mobileshop.util.MSUtil;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/member")
public class MemberController {
	//注入MemberService
	@Resource
	private MemberService memberService;
	//会员注册
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="会员注册")
	public Result regist(@ApiParam(value="用户名")@RequestParam("uname") String uname,
			@ApiParam(value="密码")@RequestParam("password") String password,
			@ApiParam(value="邮箱")@RequestParam("email") String email){
		/*try {
			uname=URLDecoder.decode(uname, "UTF-8");
			System.out.println("uname:"+uname);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} */
		//调用Service层方法
		Result result=memberService.registMember(uname, password, email);
		//返回结果信息
		return result;
	}
	//会员登录
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="会员登录")
	public Result checkLogin(@ApiParam(value="用户名")@RequestParam("uname") String uname,
			@ApiParam(value="密码")@RequestParam("password") String password){
		System.out.println("uname:"+uname);
		System.out.println(password);
		System.out.println(MSUtil.md5(password));
		//调用Service层方法
		Result result=memberService.checkLogin(uname, password);
		//返回结果信息
		return result;
	}
	//根据id加载会员信息
	@RequestMapping(value="/{memberId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载会员信息")
	public Result loadById(@PathVariable("memberId") int memberId){
		Result result=memberService.loadMemberById(memberId);
		return result;
	}
	//根据id更新会员基本信息
	@RequestMapping(method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="完善会员基本信息")
	public Result updateById(@ApiParam(value="会员编号")@RequestParam("memberId") int memberId,
			@ApiParam(value="用户名")@RequestParam("uname") String uname,
			@ApiParam(value="邮箱")@RequestParam("email") String email,
			@ApiParam(value="性别")@RequestParam("sex") int sex,
			@ApiParam(value="电话")@RequestParam("mobile") String mobile){
		Result result=memberService.updateMember(memberId, uname, email, sex, mobile);
		return result;
	}
	//根据id修改密码
	@RequestMapping(value="/{memberId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="修改密码")
	public Result updatePwd(@ApiParam(value="会员编号")@PathVariable("memberId") int memberId, 
			@ApiParam(value="旧密码")@RequestParam("oldPwd") String oldPwd, 
			@ApiParam(value="新密码")@RequestParam("newPwd") String newPwd){
		Result result=memberService.updatePwd(memberId, oldPwd, newPwd);
		return result;
	}
	//根据邮箱重置密码
	@RequestMapping(value="/pwd",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="根据邮箱重置密码")
	public Result resetPwd(@ApiParam(value="邮箱")@RequestParam("email") String email){
		Result result=memberService.resetPwd(email);
		return result;
	}
	
	//根据id更新image（设置头像）
	@RequestMapping(value="/image/{memberId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="设置头像")
	public Result updateImage(@ApiParam(value="会员编号")@PathVariable("memberId") int memberId,
			@ApiParam(value="图片地址")@RequestParam("img") String img,
			HttpServletRequest request){
		System.out.println("img:"+img);
		String url="http://"+request.getServerName()+":"+request.getLocalPort();
		Result result=memberService.updateImage(memberId, img, url);
		return result;
	}
	
	//会员登录2（根据用户名/邮箱/电话号进行登录）
	@RequestMapping(value="/login2",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="根据用户名/邮箱/电话号进行登录")
	public Result checkLogin2(@ApiParam(value="用户名/邮箱/电话号码")@RequestParam("input") String input,
			@ApiParam(value="密码")@RequestParam("password") String password){
		Result result=memberService.checkLogin2(input, password);
		return result;
	}
	
}
