package com.huatec.edu.mobileshop.dao;

import java.util.List;
import java.util.Map;

import com.huatec.edu.mobileshop.entity.Cart;

public interface CartDao {
	public int save(Cart cart);
	public int deleteById(int cart_id);
	public List<Cart> findAll();
	public Cart findById(int cart_id);
	public int dynamicUpdate(Cart cart);
	public List<Cart> findUnionByMemberId(Map map);
	public List<Cart> dynamicFind(Cart cart);
}
