package com.huatec.edu.mobileshop.util;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.huatec.edu.mobileshop.dao.MemberDao;

public class MybatisUtil {
	//获取SqlSession的方法
	public static SqlSession getSqlSession(){
		//SqlSessionFactoryBuilder——》SqlSessionFactory——》SqlSession
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		//加载sqlMapConfig.xml
		ClassLoader loader=MybatisUtil.class.getClassLoader();//MybatisUtil：自己写的类都可以
		InputStream inStream=loader.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory factory=builder.build(inStream);
		SqlSession session=factory.openSession();
		return session;
	}
	
	//测试
	public static void main(String[] args) {
		SqlSession session=MybatisUtil.getSqlSession();
		System.out.println(session);
		session.close();
	}
}
