package com.ysu.SpEL;

import com.ysu.SpEL.test.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpElApplication implements CommandLineRunner {

	@Autowired
	TestConfig testConfig;


	public static void main(String[] args) {
		SpringApplication.run(SpElApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(testConfig.getRandom());
		System.out.println(testConfig.getMap());
		System.out.println("list size : " + testConfig.getList().size() + "," + testConfig.getList().toString());
	}
}
