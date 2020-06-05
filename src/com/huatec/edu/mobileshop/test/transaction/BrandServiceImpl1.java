package com.huatec.edu.mobileshop.test.transaction;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.huatec.edu.mobileshop.dao.BrandDao;
import com.huatec.edu.mobileshop.entity.Brand;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class BrandServiceImpl1 implements BrandService1 {
	@Resource
	private BrandDao brandDao;
	@Resource
	private PlatformTransactionManager txManager;
	
	public Result addBrand(String name, String logo, String keywords, 
			String description, String url) {
		Result result=new Result();
		/**
		 * TransactionDefinition接口，用于定义一个事务
		 * Spring为我们提供了一个默认的实现类：DefaultTransactionDefinition
		 * 该类适用于大多数情况，如果该类不能满足需求
		 * 可以通过实现 TransactionDefinition接口来实现自己的事务定义。
		 */
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		//设置隔离级别
		def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		//设置传播行为
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		//TransactionStatus用于表示一个运行着的事务的状态
		TransactionStatus status = txManager.getTransaction(def);
		try {
			Brand checkBrand=brandDao.findByName(name);
			if(checkBrand!=null){
				result.setStatus(1);
				result.setMsg("已经存在此品牌");
				return result;
			}
			Brand brand=new Brand();
			brand.setBrand_id(null);
			brand.setName(name);
			brand.setLogo(logo);
			brand.setKeywords(keywords);
			brand.setDescription(description);
			brand.setUrl(url);
			brand.setDisabled(0);//默认可用
			brand.setCreatime(null);
			brand.setModifytime(null);
			brandDao.save(brand);
			//自造异常，进行测试
			String s=null;
			System.out.println(s.length());
			result.setStatus(0);
			result.setMsg("新增品牌成功");
			result.setData(brand);
			//提交
			txManager.commit(status);
		} catch (Exception e) {
			e.printStackTrace();
			//遇到异常时回滚事务
			result.setStatus(2);
			result.setMsg("新增品牌异常");
			//回滚
			txManager.rollback(status);
		}
		return result;
	}
}
