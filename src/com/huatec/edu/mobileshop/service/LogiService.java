package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.util.Result;

public interface LogiService {
	//更新物流（发货,更新状态）
	public Result updateLogi(int orderId,int shipId,String sn,String sender);
	//更新物流状态（确认收货）
	public Result updateLogiStatus(int orderId);
}
