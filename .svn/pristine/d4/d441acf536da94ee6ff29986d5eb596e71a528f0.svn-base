package com.huatec.edu.mobileshop.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatec.edu.mobileshop.dao.ShipDao;
import com.huatec.edu.mobileshop.entity.Ship;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class ShipServiceImpl implements ShipService {
	@Resource
	private ShipDao shipDao;

	//新增货运公司
	public Result addShip(String name, String code) {
		Result result=new Result();
		Ship findShip1=new Ship();
		findShip1.setName(name);
		Ship checkShip1=shipDao.dynamicFind(findShip1);
		if(checkShip1!=null){
			result.setStatus(1);
			result.setMsg("此名称已经存在");
			return result;
		}
		Ship findShip2=new Ship();
		findShip2.setCode(code);
		Ship checkShip2=shipDao.dynamicFind(findShip2);
		if(checkShip2!=null){
			result.setStatus(1);
			result.setMsg("此代码已经存在");
			return result;
		}
		Ship ship=new Ship();
		ship.setShip_id(null);
		ship.setName(name);
		ship.setCode(code);
		ship.setCreatime(null);
		ship.setModifytime(null);
		shipDao.save(ship);
		result.setStatus(0);
		result.setMsg("新增货运公司成功");
		result.setData(ship);
		return result;
	}

	//查询所有
	public Result loadAllShip() {
		Result result=new Result();
		List<Ship> ships=shipDao.findAll();
		result.setStatus(0);
		result.setMsg("查询所有货运公司成功");
		result.setData(ships);
		return result;
	}

	//根据id查询
	public Result loadShipById(int shipId) {
		Result result=new Result();
		Ship ship=shipDao.findById(shipId);
		if(ship==null){
			result.setStatus(1);
			result.setMsg("不存在此货运公司");
			return result;
		}
		result.setStatus(0);
		result.setMsg("查询货运公司成功");
		result.setData(ship);
		return result;
	}

	//根据id更新
	public Result updateShip(int shipId, String name, String code) {
		Result result=new Result();
		Ship findShip1=new Ship();
		findShip1.setName(name);
		Ship checkShip1=shipDao.dynamicFind(findShip1);
		if(checkShip1!=null){
			result.setStatus(1);
			result.setMsg("此名称已经存在");
			return result;
		}
		Ship findShip2=new Ship();
		findShip2.setCode(code);
		Ship checkShip2=shipDao.dynamicFind(findShip2);
		if(checkShip2!=null){
			result.setStatus(1);
			result.setMsg("此代码已经存在");
			return result;
		}
		Ship ship=new Ship();
		ship.setShip_id(shipId);
		ship.setName(name);
		ship.setCode(code);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		ship.setModifytime(now);
		shipDao.dynamicUpdate(ship);
		result.setStatus(0);
		result.setMsg("更新货运公司信息成功");
		return result;
	}

	//根据id删除
	public Result deleteShipById(int shipId) {
		Result result=new Result();
		Ship ship=shipDao.findById(shipId);
		if(ship==null){
			result.setStatus(1);
			result.setMsg("不存在此货运公司");
			return result;
		}
		shipDao.deleteById(shipId);
		result.setStatus(0);
		result.setMsg("删除货运公司成功");
		return result;
	}

}
