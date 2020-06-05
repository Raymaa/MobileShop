package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.Payment;

public interface PaymentDao {
	public int save(Payment payment);
	public List<Payment> findAll();
	public int deleteById(int payment_id);
	public Payment findById(int payment_id);
	public int dynamicUpdate(Payment payment);
}
