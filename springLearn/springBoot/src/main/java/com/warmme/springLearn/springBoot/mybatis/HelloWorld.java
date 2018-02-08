package com.warmme.springLearn.springBoot.mybatis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@RequestMapping("/")
	String hello() {
		return "Hello World!";
	}

}