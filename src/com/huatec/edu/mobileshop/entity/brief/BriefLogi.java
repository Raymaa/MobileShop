package com.huatec.edu.mobileshop.entity.brief;

import java.io.Serializable;

public class BriefLogi implements Serializable {
	private String sn;
	private Double carriage;//运费
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Double getCarriage() {
		return carriage;
	}
	public void setCarriage(Double carriage) {
		this.carriage = carriage;
	}
	@Override
	public String toString() {
		return "BriefLogi [sn=" + sn + ", carriage=" + carriage + "]";
	}
	
}
