package com.warmme.springLearn.springBoot.data.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.warmme.springLearn.springBoot.data.mongodb",
mongoTemplateRef = PrimaryMongoConfig.MONGO_TEMPLATE)
public class PrimaryMongoConfig {
	
	protected static final String MONGO_TEMPLATE = "primaryMongoTemplate";

}
