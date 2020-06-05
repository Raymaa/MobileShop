package com.huatec.edu.mobileshop.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
/*
 * SwaggerUI配置
 */
//用@Configuration注解该类，等价于XML中配置beans
//如果需要使用junit进行测试，需注释掉@Configuration
@Configuration
//@EnableSwagger：使swagger生效
@EnableSwagger
//@EnableWebMvc 启动Spring MVC支持
//@EnableWebMvc
//@ComponentScan 配置包扫描
//@ComponentScan(basePackages ={"com.huatec.edu.mobileshop"})
public class SwaggerConfig {
	private SpringSwaggerConfig springSwaggerConfig;
	//需要自动注入SpringSwaggerConfig
	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig){
		this.springSwaggerConfig = springSwaggerConfig;
	}
	//用@Bean标注方法等价于XML中配置bean
	@Bean
	public SwaggerSpringMvcPlugin customImplementation(){
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
				.apiInfo(apiInfo())
				.includePatterns(".*?");
	}
	private ApiInfo apiInfo(){
		ApiInfo apiInfo = new ApiInfo(
				"移动电商后台API",
				"My Apps API Description",
				"My Apps API terms of service",
				"My Apps API Contact Email",
				"My Apps API Licence Type",
				"My Apps API License URL");
		return apiInfo;
	}

}
