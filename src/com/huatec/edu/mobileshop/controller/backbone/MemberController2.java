package com.huatec.edu.mobileshop.controller.backbone;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

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
@RequestMapping("/backbone/member")
public class MemberController2 {
	//注入MemberService
	@Resource
	private MemberService memberService;
	//会员注册
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="会员注册")
	public Result regist(HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		String uname=(String) jmap.get("uname");
        String password=(String) jmap.get("password");
        String email=(String) jmap.get("email");
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
	public Result checkLogin(HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		String uname=(String) jmap.get("uname");
        String password=(String) jmap.get("password");
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
	public Result updateById(HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		int memberId=Integer.parseInt((String) jmap.get("memberId"));
		String uname=(String) jmap.get("uname");
        String email=(String) jmap.get("email");
        int sex=Integer.parseInt((String) jmap.get("sex"));
        String mobile=(String) jmap.get("mobile");
		Result result=memberService.updateMember(memberId, uname, email, sex, mobile);
		return result;
	}
	//根据id修改密码
	@RequestMapping(value="/{memberId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="修改密码")
	public Result updatePwd(@ApiParam(value="会员编号")@PathVariable("memberId") int memberId, 
			HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		String oldPwd=(String) jmap.get("oldPwd");
        String newPwd=(String) jmap.get("newPwd");
		Result result=memberService.updatePwd(memberId, oldPwd, newPwd);
		return result;
	}
	//根据邮箱重置密码
	@RequestMapping(value="/pwd",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="根据邮箱重置密码")
	public Result resetPwd(HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		String email=(String) jmap.get("email");
		Result result=memberService.resetPwd(email);
		return result;
	}
	
	//根据id更新image（设置头像）
	@RequestMapping(value="/image/{memberId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="设置头像")
	public Result updateImage(@ApiParam(value="会员编号")@PathVariable("memberId") int memberId,
			HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		String img=(String) jmap.get("img");
		String url="http://"+request.getServerName()+":"+request.getLocalPort();
		Result result=memberService.updateImage(memberId, img, url);
		return result;
	}
	
	//会员登录2（根据用户名/邮箱/电话号进行登录）
	@RequestMapping(value="/login2",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="根据用户名/邮箱/电话号进行登录")
	public Result checkLogin2(HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		String input=(String) jmap.get("input");
		String password=(String) jmap.get("password");
		Result result=memberService.checkLogin2(input, password);
		return result;
	}
	
}
