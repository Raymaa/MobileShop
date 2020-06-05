package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.util.Result;

public interface AdminService {
	//根据手机号添加
	public Result addAdmin(String mobile,String realName,int roleId);
	//登录验证
	public Result checkLogin(String input,String password);
	//完善基本信息
	public Result updateAdmin(int adminId,String username,String password,String email,int sex);
	//更新电话号和真实姓名
	public Result updateInfo(int adminId,String mobile,String realName,int roleId);
	//查询所有管理员（关联查询）
	public Result loadAllAdmin();
	//根据id查询
	public Result loadAdminById(int adminId);
	//删除管理员
	public Result deleteAdminById(int adminId);
}
