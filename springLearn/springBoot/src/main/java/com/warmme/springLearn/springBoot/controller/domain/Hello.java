package com.warmme.springLearn.springBoot.controller.domain;

import org.springframework.beans.factory.annotation.Value;

public class Hello {

	@Value("${com.warmme.hello}")
	public String hello;

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}

}
