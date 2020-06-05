package com.huatec.edu.mobileshop.test.transaction;

import com.huatec.edu.mobileshop.util.Result;

public interface BrandService1 {
	public Result addBrand(String name, String logo, String keywords, 
			String description, String url);
}
