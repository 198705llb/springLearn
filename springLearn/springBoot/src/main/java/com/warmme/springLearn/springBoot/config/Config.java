package com.warmme.springLearn.springBoot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "com.warmme")
@PropertySource("classpath:config.properties")
@MapperScan("com.warmme.springLearn.springBoot")
public class Config {

	private String hello;

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	} 
	
}
