package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.entity.Member;
import com.huatec.edu.mobileshop.util.Result;

public interface MemberService {
	//会员注册
	public Result registMember(String uname,String password,String email);
	//会员登录
	public Result checkLogin(String uname,String password);
	//根据id加载会员信息
	public Result loadMemberById(int memberId);
	//根据id更新会员基本信息
	public Result updateMember(int memberId,String uname,String email,int sex,String mobile);
	//根据id修改密码
	public Result updatePwd(int memberId,String oldPwd,String newPwd);
	//根据邮箱重置密码
	public Result resetPwd(String email);
	//根据id更新image（设置会员头像）
	public Result updateImage(int memberId, String img, String url);
	//根据用户名/邮箱/电话号进行登录
	public Result checkLogin2(String input,String password);
}
