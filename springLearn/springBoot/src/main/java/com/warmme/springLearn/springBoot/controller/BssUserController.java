package com.warmme.springLearn.springBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.warmme.springLearn.springBoot.data.mongodb.PrimaryMongoObject;
import com.warmme.springLearn.springBoot.data.mongodb.PrimaryRepository;

@RestController
public class BssUserController {

	@Autowired
	private PrimaryRepository primaryRepository;

	@RequestMapping("/bssUser")
	public String getUsers() {
		List<PrimaryMongoObject> result = primaryRepository.findAll();
		return JSONObject.toJSONString(result);
	}

}
