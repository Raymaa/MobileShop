package com.huatec.edu.mobileshop.util;

import java.io.Serializable;
//用于分页
public class Page implements Serializable {
	private int current;//第几页
	private int pageSize;//一页几条
	
	//sql中用#{begin}获取
	public int getBegin(){
		int begin=(current-1)*pageSize;
		return begin;
	}
	//get、set方法
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//toString方法
	public String toString() {
		return "Page [current=" + current + ", pageSize=" + pageSize + "]";
	}
}
