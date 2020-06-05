package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.PayType;

public interface PayTypeDao {
	public int save(PayType payType);
	public List<PayType> findAll();
	public int deleteById(int paytype_id);
	public PayType findById(int paytype_id);
	public int dynamicUpdate(PayType payType);
	public PayType findByName(String name);
}
