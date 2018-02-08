package com.warmme.springLearn.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warmme.springLearn.springBoot.config.Config;

@RestController
public class HelloController {
	
	@Autowired
	private Config config;

	@RequestMapping("/hello")
	public String hello(){
		return config.getHello();
	}
}
