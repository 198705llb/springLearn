package com.warmme.springLearn.springBoot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.warmme.springLearn.springBoot.data.mongodb.PrimaryMongoObject;
import com.warmme.springLearn.springBoot.data.mongodb.PrimaryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MuliDatabaseTest {
	
	@Autowired
    private PrimaryRepository primaryRepository;
	
	@Test
    public void TestSave() {
		this.primaryRepository.save(new PrimaryMongoObject(null, "第一个库的对象"));
	}

}
