package com.warmme.springLearn.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.warmme.springLearn.springBoot.config.Config;
import com.warmme.springLearn.springBoot.data.mongodb.props.MultipleMongoProperties;

@EnableConfigurationProperties({Config.class,MultipleMongoProperties.class})
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class Main {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}
}
