package com.warmme.springLearn.springBoot.data.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrimaryRepository extends MongoRepository<PrimaryMongoObject, String>{

}
