package com.huatec.edu.mobileshop.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatec.edu.mobileshop.dao.PayTypeDao;
import com.huatec.edu.mobileshop.entity.PayType;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class PayTypeServiceImpl implements PayTypeService {
	@Resource
	private PayTypeDao payTypeDao;
	
	public Result addPayType(String name, String config, String description) {
		Result result=new Result();
		PayType checkPT=payTypeDao.findByName(name);
		if(checkPT!=null){
			result.setStatus(1);
			result.setMsg("已经存在此支付类型");
			return result;
		}
		PayType payType=new PayType();
		payType.setPaytype_id(null);
		payType.setName(name);
		payType.setConfig(config);
		payType.setDescription(description);
		payType.setCreatime(null);
		payType.setModifytime(null);
		payTypeDao.save(payType);
		result.setStatus(0);
		result.setMsg("新增支付类型成功");
		result.setData(payType);
		return result;
	}

	public Result loadAllPayType() {
		Result result=new Result();
		List<PayType> pts=payTypeDao.findAll();
		result.setStatus(0);
		result.setMsg("查询所有支付类型成功");
		result.setData(pts);
		return result;
	}

	public Result loadPayTypeById(int payTypeId) {
		Result result=new Result();
		PayType payType=payTypeDao.findById(payTypeId);
		if(payType==null){
			result.setStatus(1);
			result.setMsg("不存在此支付类型");
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载此支付类型成功");
		result.setData(payType);
		return result;
	}

	public Result updatePayType(int payTypeId, String name, String config, String description) {
		Result result=new Result();
		PayType checkPT=payTypeDao.findById(payTypeId);
		if(checkPT==null){
			result.setStatus(1);
			result.setMsg("不存在此支付类型");
			return result;
		}
		PayType checkPT2=payTypeDao.findByName(name);
		if(checkPT2!=null && !name.equals(checkPT.getName())){
			result.setStatus(1);
			result.setMsg("已经存在此支付类型");
			return result;
		}
		PayType payType=new PayType();
		payType.setPaytype_id(payTypeId);
		payType.setName(name);
		payType.setConfig(config);
		payType.setDescription(description);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		payType.setModifytime(now);
		payTypeDao.dynamicUpdate(payType);
		result.setStatus(0);
		result.setMsg("更新支付类型成功");
		return result;
	}

	public Result deletePayTypeById(int payTypeId) {
		Result result=new Result();
		PayType checkPT=payTypeDao.findById(payTypeId);
		if(checkPT==null){
			result.setStatus(1);
			result.setMsg("不存在此支付类型");
			return result;
		}
		payTypeDao.deleteById(payTypeId);
		result.setStatus(0);
		result.setMsg("删除支付类型成功");
		return result;
	}

}
