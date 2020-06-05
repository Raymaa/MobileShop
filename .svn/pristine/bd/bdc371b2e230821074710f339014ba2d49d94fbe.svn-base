package com.huatec.edu.mobileshop.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatec.edu.mobileshop.dao.CartDao;
import com.huatec.edu.mobileshop.dao.GoodsDao;
import com.huatec.edu.mobileshop.dao.MemberDao;
import com.huatec.edu.mobileshop.entity.Cart;
import com.huatec.edu.mobileshop.entity.Goods;
import com.huatec.edu.mobileshop.entity.Member;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class CartServiceImpl implements CartService {
	@Resource
	private CartDao cartDao;
	@Resource
	private GoodsDao goodsDao;
	@Resource
	private MemberDao memberDao;
	//新增
	public Result addCart(int memberId, int goodsId, int goodsNum) {
		Result result=new Result();
		Goods goods=goodsDao.findById(goodsId);
		if(goods==null){
			result.setStatus(1);
			result.setMsg("不存在此商品");
			return result;
		}
		if(goods.getMkt_enable()==1){
			result.setStatus(1);
			result.setMsg("此商品已下架");
			return result;
		}
		double price=goods.getPrice();
		Cart cart1=new Cart();
		cart1.setMember_id(memberId);
		cart1.setGoods_id(goodsId);
		List<Cart> carts=cartDao.dynamicFind(cart1);
		//购物车中没有此商品
		if(carts.isEmpty()){
			Cart cart=new Cart();
			cart.setCart_id(null);
			cart.setMember_id(memberId);
			cart.setGoods_id(goodsId);
			cart.setGoods_num(goodsNum);
			cart.setChoose(1);//默认为“没选择”
			cart.setAmount(goodsNum*price);
			cart.setCreatime(null);
			cart.setModifytime(null);
			cartDao.save(cart);
			result.setStatus(0);
			result.setMsg("添加到购物车成功");
			result.setData(cart);
			return result;
		}
		//购物车中已包含此商品
		Cart updateCart=new Cart();
		for(Cart checkCart:carts){
			int cartId=checkCart.getCart_id();
			updateCart.setCart_id(cartId);
			int newGoodsNum=checkCart.getGoods_num()+goodsNum;
			updateCart.setGoods_num(newGoodsNum);
			updateCart.setAmount(newGoodsNum*price);
			Timestamp now=new Timestamp(System.currentTimeMillis());
			updateCart.setModifytime(now);
			cartDao.dynamicUpdate(updateCart);
			result.setData(cartDao.findById(cartId));
		}
		result.setStatus(0);
		result.setMsg("添加到购物车成功");
		return result;
	}
	//根据会员id加载
	public Result loadCartByMemberId(int memberId) {
		Result result=new Result();
		Member member=memberDao.findById(memberId);
		if(member==null){
			result.setStatus(1);
			result.setMsg("不存在此会员");
			return result;
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("member_id", memberId);
		List<Cart> carts=cartDao.findUnionByMemberId(map);
		result.setStatus(0);
		result.setMsg("加载购物车成功");
		result.setData(carts);
		return result;
	}
	//根据会员id加载选中的记录
	public Result loadChooseCartByMemberId(int memberId) {
		Result result=new Result();
		Member member=memberDao.findById(memberId);
		if(member==null){
			result.setStatus(1);
			result.setMsg("不存在此会员");
			return result;
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("member_id", memberId);
		map.put("choose", 0);
		List<Cart> carts=cartDao.findUnionByMemberId(map);
		result.setStatus(0);
		result.setMsg("加载选中的商品成功");
		result.setData(carts);
		return result;
	}
	//根据id更新
	public Result updateCart(int cartId, int goodsNum, int choose) {
		Result result=new Result();
		Cart checkCart=cartDao.findById(cartId);
		if(checkCart==null){
			result.setStatus(1);
			result.setMsg("没有此条记录");
			return result;
		}
		Goods goods=goodsDao.findById(checkCart.getGoods_id());
		if(goods==null){
			result.setStatus(1);
			result.setMsg("不存在此商品");
			return result;
		}
		if(goods.getMkt_enable()==1){
			result.setStatus(1);
			result.setMsg("此商品已下架");
			return result;
		}
		double price=goods.getPrice();
		Cart cart=new Cart();
		cart.setCart_id(cartId);
		cart.setGoods_num(goodsNum);
		cart.setAmount(goodsNum*price);
		cart.setChoose(choose);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		cart.setModifytime(now);
		cartDao.dynamicUpdate(cart);
		result.setStatus(0);
		result.setMsg("更新购物车记录成功");
		return result;
	}
	//根据id更新数量
	public Result updateGoodsNum(int cartId, int goodsNum) {
		Result result=new Result();
		Cart checkCart=cartDao.findById(cartId);
		if(checkCart==null){
			result.setStatus(1);
			result.setMsg("没有此条记录");
			return result;
		}
		Goods goods=goodsDao.findById(checkCart.getGoods_id());
		if(goods==null){
			result.setStatus(1);
			result.setMsg("不存在此商品");
			return result;
		}
		if(goods.getMkt_enable()==1){
			result.setStatus(1);
			result.setMsg("此商品已下架");
			return result;
		}
		double price=goods.getPrice();
		Cart cart=new Cart();
		cart.setCart_id(cartId);
		cart.setGoods_num(goodsNum);
		cart.setAmount(goodsNum*price);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		cart.setModifytime(now);
		cartDao.dynamicUpdate(cart);
		result.setStatus(0);
		result.setMsg("更新商品数量成功");
		return result;
	}
	//根据id更新状态
	public Result updateChoose(int cartId, int choose) {
		Result result=new Result();
		Cart checkCart=cartDao.findById(cartId);
		if(checkCart==null){
			result.setStatus(1);
			result.setMsg("没有此条记录");
			return result;
		}
		Cart cart=new Cart();
		cart.setCart_id(cartId);
		cart.setChoose(choose);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		cart.setModifytime(now);
		cartDao.dynamicUpdate(cart);
		result.setStatus(0);
		result.setMsg("更新商品状态成功");
		return result;
	}
	//根据id删除
	public Result deleteCartById(int cartId) {
		Result result=new Result();
		Cart checkCart=cartDao.findById(cartId);
		if(checkCart==null){
			result.setStatus(1);
			result.setMsg("没有此条记录");
			return result;
		}
		cartDao.deleteById(cartId);
		result.setStatus(0);
		result.setMsg("删除购物车记录成功");
		return result;
	}
	

}
