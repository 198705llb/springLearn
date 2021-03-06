package com.warmme.springLearn.springBoot.data.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.warmme.springLearn.springBoot.data.mongodb.props.MultipleMongoProperties;

@Configuration
public class MultiMongodbConfig {
	
	@Autowired
    private MultipleMongoProperties mongoProperties;
	
	@Primary
	@Bean(name = PrimaryMongoConfig.MONGO_TEMPLATE)
	public MongoTemplate primaryMongoTemplate() throws Exception {
		return new MongoTemplate(primaryFactory(this.mongoProperties.getPrimary()));
	}
	
	@Bean
    @Primary
	public MongoDbFactory primaryFactory(MongoProperties mongo) throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
				mongo.getDatabase());
	}

}
