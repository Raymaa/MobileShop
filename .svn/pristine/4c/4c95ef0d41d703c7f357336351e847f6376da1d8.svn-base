package com.huatec.edu.mobileshop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatec.edu.mobileshop.dao.MemberDao;
import com.huatec.edu.mobileshop.dao.OrderGoodsDao;
import com.huatec.edu.mobileshop.entity.Member;
import com.huatec.edu.mobileshop.entity.OrderGoods;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {
	@Resource
	private OrderGoodsDao orderGoodsDao;
	@Resource
	private MemberDao memberDao;
	
	//根据会员id加载（订单商品表、订单表、商品表关联查询）
	/*public Result loadUnionByMemberId(int memberId) {
		Result result=new Result();
		Member member=memberDao.findById(memberId);
		if(member==null){
			result.setStatus(1);
			result.setMsg("不存在此会员");
			return result;
		}
		List<OrderGoods> ogs=orderGoodsDao.findUnionByMemberId(memberId);
		result.setStatus(0);
		result.setMsg("加载订单成功");
		result.setData(ogs);
		return result;
	}*/

}
