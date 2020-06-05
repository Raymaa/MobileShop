package com.huatec.edu.mobileshop.test.transaction;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.huatec.edu.mobileshop.dao.BrandDao;
import com.huatec.edu.mobileshop.entity.Brand;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class BrandServiceImpl11 implements BrandService1 {
	@Resource
	private BrandDao brandDao;
	@Resource
	private PlatformTransactionManager txManager;
	
	public Result addBrand(String name, String logo, String keywords, 
			String description, String url) {
		Result result=new Result();
		//创建事务模板类
		TransactionTemplate transactionTemplate = new TransactionTemplate(txManager);
		//设置隔离级别
		transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		//设置传播行为
		transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		/**
		 * transactionTemplate.execute：执行需要事务管理的回调
		 * TransactionCallback：回调
		 */
		transactionTemplate.execute(new TransactionCallback<Object>(){
			public Object doInTransaction(TransactionStatus status) {
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
				return result;
			}
		});
		return result;
	}
}
