package com.huatec.edu.mobileshop.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.MemberAddressService;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/member_address")
public class MemberAddressController {
	//注入MemberService
	@Resource
	private MemberAddressService addressService;
	
	//新增会员地址信息
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增会员地址")
	public Result add(@ApiParam(value="会员编号")@RequestParam("memberId") int memberId, 
			@ApiParam(value="省")@RequestParam("province") String provice, 
			@ApiParam(value="市")@RequestParam("city") String city, 
			@ApiParam(value="区")@RequestParam("region") String region, 
			@ApiParam(value="详细地址")@RequestParam("addr") String addr, 
			@ApiParam(value="电话")@RequestParam("mobile") String mobile,
			@ApiParam(value="收件人")@RequestParam("receiver") String receiver){
		/*System.out.println("province:"+provice);
		System.out.println("city:"+city);
		String deProvince;
		try {
			deProvince=URLDecoder.decode(provice,"UTF-8");
			System.out.println("deProvince:"+deProvince);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		
		Result result=
				addressService.addAddress(memberId, provice, city, region, addr, mobile, receiver);
		return result;
	}
	//根据会员id加载会员地址信息（关联查询）
	@RequestMapping(value="/member/{memberId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据会员编号加载会员的地址信息（关联查询）")
	public Result loadByMemberId(@PathVariable("memberId") int memberId){
		Result result=addressService.loadAddressesByMemberId(memberId);
		return result;
	}
	//根据会员id加载会员地址信息
	@RequestMapping(value="/member2/{memberId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据会员编号加载会员的地址信息")
	public Result loadByMemberId2(@PathVariable("memberId") int memberId){
		Result result=addressService.loadByMemberId(memberId);
		return result;
	}
	//根据id加载地址信息
	@RequestMapping(value="/{addressId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载会员地址信息")
	public Result loadById(@PathVariable("addressId") int addressId){
		Result result=addressService.loadAddressById(addressId);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{addressId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新会员地址信息")
	public Result updateById(@ApiParam(value="会员地址编号")@PathVariable("addressId") int addressId,
			@ApiParam(value="省")@RequestParam("province") String provice, 
			@ApiParam(value="市")@RequestParam("city") String city, 
			@ApiParam(value="区")@RequestParam("region") String region, 
			@ApiParam(value="详细地址")@RequestParam("addr") String addr, 
			@ApiParam(value="电话")@RequestParam("mobile") String mobile,
			@ApiParam(value="收件人")@RequestParam("receiver") String receiver){
		Result result=addressService.updateAddress(addressId, provice, city, 
				region, addr, mobile, receiver);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{addressId}",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除会员地址信息")
	public Result deleteById(@PathVariable("addressId") int addressId){
		Result result=addressService.deleteAddressById(addressId);
		return result;
	}
}
