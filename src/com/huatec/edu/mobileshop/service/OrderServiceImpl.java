package com.huatec.edu.mobileshop.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatec.edu.mobileshop.dao.CartDao;
import com.huatec.edu.mobileshop.dao.GoodsDao;
import com.huatec.edu.mobileshop.dao.LogiDao;
import com.huatec.edu.mobileshop.dao.MemberAddressDao;
import com.huatec.edu.mobileshop.dao.MemberDao;
import com.huatec.edu.mobileshop.dao.OrderDao;
import com.huatec.edu.mobileshop.dao.OrderGoodsDao;
import com.huatec.edu.mobileshop.dao.OrderLogDao;
import com.huatec.edu.mobileshop.dao.PayTypeDao;
import com.huatec.edu.mobileshop.dao.PaymentDao;
import com.huatec.edu.mobileshop.dao.ShipDao;
import com.huatec.edu.mobileshop.entity.Cart;
import com.huatec.edu.mobileshop.entity.Goods;
import com.huatec.edu.mobileshop.entity.Logi;
import com.huatec.edu.mobileshop.entity.Member;
import com.huatec.edu.mobileshop.entity.MemberAddress;
import com.huatec.edu.mobileshop.entity.Order;
import com.huatec.edu.mobileshop.entity.OrderGoods;
import com.huatec.edu.mobileshop.entity.OrderLog;
import com.huatec.edu.mobileshop.entity.PayType;
import com.huatec.edu.mobileshop.entity.Payment;
import com.huatec.edu.mobileshop.entity.Ship;
import com.huatec.edu.mobileshop.entity.brief.BriefOrderLog;
import com.huatec.edu.mobileshop.entity.select.OrderResult;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao orderDao;
	@Resource
	private MemberDao memberDao;
	@Resource
	private CartDao cartDao;
	@Resource
	private OrderGoodsDao orderGoodsDao;
	@Resource
	private GoodsDao goodsDao;
	@Resource
	private OrderLogDao orderLogDao;
	@Resource
	private MemberAddressDao memberAddressDao;
	@Resource
	private PaymentDao paymentDao;
	@Resource
	private LogiDao logiDao;
	@Resource
	private ShipDao shipDao;
	@Resource
	private PayTypeDao payTypeDao;
	//创建订单
	public Result addOrder(int memberId,int addressId,int paytypeId,double carriage) {
		Result result=new Result();
		Member member=memberDao.findById(memberId);
		if(member==null){
			result.setStatus(1);
			result.setMsg("不存在此会员");
			return result;
		}
		//购物车中选中的商品
		Cart findCart=new Cart();
		findCart.setMember_id(memberId);
		findCart.setChoose(0);
		List<Cart> carts=cartDao.dynamicFind(findCart);
		if(carts.isEmpty()){
			result.setStatus(1);
			result.setMsg("没有选中的商品");
			return result;
		}
		//判断addressId是否关联memberId
		MemberAddress ma=memberAddressDao.findById(addressId);
		if(ma.getMember_id()!=memberId){
			result.setStatus(1);
			result.setMsg("不是此会员的地址");
			return result;
		}
		double totalAmount=carriage;
		for(Cart cart:carts){
			double amount=cart.getAmount();
			totalAmount+=amount;
		}
		//新增订单
		Order order=new Order();
		order.setOrder_id(null);
		//订单编号采用UUID生成
		order.setSn(UUID.randomUUID().toString().replaceAll("-", ""));
		order.setMember_id(memberId);
		order.setStatus(0);//订单状态,0:创建
		//创建payment
		Payment payment=new Payment();
		payment.setPayment_id(null);
		Random r=new Random();
		Long time=new Date().getTime();
		payment.setSn(Integer.toString(memberId)+time+r.nextInt(100));
		payment.setPaytype_id(paytypeId);
		payment.setAmount(totalAmount);
		payment.setStatus(0);//支付状态，0：创建
		payment.setPaytime(null);
		payment.setRemark("");
		paymentDao.save(payment);
		//设置支付id
		order.setPayment_id(payment.getPayment_id());
		//创建logi
		Logi logi=new Logi();
		logi.setLogi_id(null);
		logi.setShip_id(0);//还未关联货运公司id
		logi.setSn("");
		logi.setCarriage(carriage);
		logi.setSender("");
		logi.setStatus(0);//物流状态，0：创建
		logi.setCreatime(null);
		logi.setModifytime(null);
		logiDao.save(logi);
		//设置物流id
		order.setLogi_id(logi.getLogi_id());
		order.setTotal_amount(totalAmount);
		order.setAddress_id(addressId);
		order.setCreatime(null);
		order.setModifytime(null);
		orderDao.save(order);
		int orderId=order.getOrder_id();
		//在订单商品表中增加数据
		for(Cart cart1:carts){
			OrderGoods orderGoods=new OrderGoods();
			orderGoods.setId(null);
			orderGoods.setOrder_id(orderId);
			int goodsId=cart1.getGoods_id();
			orderGoods.setGoods_id(goodsId);
			orderGoods.setGoods_num(cart1.getGoods_num());
			Goods goods=goodsDao.findById(goodsId);
			orderGoods.setPrice(goods.getPrice());
			orderGoodsDao.save(orderGoods);
		}
		//将购物车中的记录删除
		for(Cart cart2:carts){
			cartDao.deleteById(cart2.getCart_id());
		}
		//在订单日志表中记录
		OrderLog orderLog=new OrderLog();
		orderLog.setLog_id(null);
		orderLog.setOrder_id(orderId);
		orderLog.setStatus(order.getStatus());
		orderLog.setTime(order.getCreatime());
		orderLogDao.save(orderLog);
		result.setStatus(0);
		result.setMsg("新建订单成功");
		result.setData(order);
		return result;
	}
	
	//根据id加载
	public Result loadOrderById(int orderId) {
		Result result=new Result();
		Order order=orderDao.findById(orderId);
		if(order==null){
			result.setStatus(1);
			result.setMsg("此订单不存在");
			return result;
		}
		//获取收货地址
		int addressId=order.getAddress_id();
		MemberAddress ma=memberAddressDao.findById(addressId);
		String memberAddress=ma.getReceiver()+","+ma.getMobile()+","+ma.getProvice()
		+ma.getCity()+ma.getRegion()+ma.getAddr();
		//装载参数
		OrderResult orderResult=new OrderResult();
		orderResult.setOrder_id(orderId);//订单编号
		orderResult.setOrder_sn(order.getSn());//订单号
		orderResult.setOrder_status(order.getStatus());//订单状态
		orderResult.setMember_address(memberAddress);//收货人地址信息
		//获取物流
		int logiId=order.getLogi_id();
		if(logiId!=0){
			Logi logi=logiDao.findById(logiId);
			//获取货运公司
			int shipId=logi.getShip_id();
			Ship ship=shipDao.findById(shipId);
			orderResult.setShip_name(ship.getName());//货运公司名字
			orderResult.setLogi_sn(logi.getSn());//物流编号
			orderResult.setLogi_status(logi.getStatus());//物流状态
			orderResult.setCarriage(logi.getCarriage());//运费
		}else{
			orderResult.setShip_name("");
			orderResult.setLogi_sn("");
			orderResult.setLogi_status(null);
			orderResult.setCarriage(null);
		}
		//获取支付方式
		int paymentId=order.getPayment_id();
		if(paymentId!=0){
			Payment payment=paymentDao.findById(paymentId);
			int payTypeId=payment.getPaytype_id();
			PayType payType=payTypeDao.findById(payTypeId);
			orderResult.setPaytype_name(payType.getName());//支付类型的名称
		}else{
			orderResult.setPaytype_name("");
		}
		//获取订单商品集合
		List<OrderGoods> ogs=orderGoodsDao.findUnionByOrderId(orderId);
		orderResult.setOgs(ogs);//商品集合
		//获取日志集合
		List<BriefOrderLog> bols=orderLogDao.findByOrderId(orderId);
		orderResult.setBols(bols);//订单日志
		result.setStatus(0);
		result.setMsg("加载订单详情成功");
		result.setData(orderResult);
		return result;
	}
	
	//根据会员id加载（“我的订单”页面，订单表、订单商品表、商品表关联查询）
	public Result loadOrderByMemberId(int memberId) {
		Result result=new Result();
		Member member=memberDao.findById(memberId);
		if(member==null){
			result.setStatus(1);
			result.setMsg("不存在此会员");
			return result;
		}
		List<Order> orders=orderDao.findUnionByMemberId(memberId);
		result.setStatus(0);
		result.setMsg("加载订单成功");
		result.setData(orders);
		return result;
	}
	
	//加载所有订单（分页）
	public Result loadAllOrderByPage(int current) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		int pageSize=10;//每页10条
		int begin=(current-1)*pageSize;
		map.put("begin", begin);
		map.put("pageSize", pageSize);
		List<Order> os=orderDao.dynamicFindUnion(map);
		if(os.isEmpty()){
			result.setStatus(1);
			result.setMsg("此页没有订单");
			result.setData(os);
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载所有订单成功");
		result.setData(os);
		return result;
	}
	
	//根据状态加载订单（待付款、待发货）
	public Result loadOrderByStatus(int status,int current) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		int pageSize=10;//每页10条
		int begin=(current-1)*pageSize;
		map.put("begin", begin);
		map.put("pageSize", pageSize);
		map.put("status", status);
		List<Order> os=orderDao.dynamicFindUnion(map);
		if(os.isEmpty()){
			result.setStatus(1);
			result.setMsg("此页没有订单");
			result.setData(os);
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载订单成功");
		result.setData(os);
		return result;
	}

	//更新订单状态（取消订单）
	public Result updateOrderStatus(int orderId) {
		Result result=new Result();
		Order checkOrder=orderDao.findById(orderId);
		if(checkOrder==null){
			result.setStatus(1);
			result.setMsg("不存在此订单");
			return result;
		}
		if(checkOrder.getStatus()!=0){
			result.setStatus(1);
			result.setMsg("此订单不能取消");
			return result;
		}
		//删除和此订单相关的支付记录
		int paymentId=checkOrder.getPayment_id();
		paymentDao.deleteById(paymentId);
		//删除和此订单相关的物流记录
		int logiId=checkOrder.getLogi_id();
		logiDao.deleteById(logiId);
		//更新订单状态
		Order order=new Order();
		order.setOrder_id(orderId);
		order.setStatus(4);//4:订单取消
		order.setPayment_id(0);//将关联的支付记录更新为0
		order.setLogi_id(0);//将关联的物流记录更新为0
		orderDao.dynamicUpdate(order);
		//向日志添加一条记录
		OrderLog orderLog=new OrderLog();
		orderLog.setLog_id(null);
		orderLog.setOrder_id(orderId);
		orderLog.setStatus(order.getStatus());
		Timestamp now=new Timestamp(System.currentTimeMillis());
		orderLog.setTime(now);
		orderLogDao.save(orderLog);
		result.setStatus(0);
		result.setMsg("取消订单成功");
		return result;
	}

}
