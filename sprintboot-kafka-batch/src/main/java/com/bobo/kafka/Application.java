package com.bobo.kafka;

import com.bobo.kafka.comsumer.Receiver;
import com.bobo.kafka.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Value("${kafka.topic.batch}")
	String topic;

	@Autowired
	Sender sender;

	@Autowired
	Receiver receiver;

	@Override
	public void run(String... strings) throws Exception {

//		for (int i = 0; i < 10; i++) {
//			sender.send(topic, "foo" + i);
//		}
		receiver.getLatch().await(10, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args).close();
	}
}
