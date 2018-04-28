package com.bobo.kafka.comsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

  public static final int COUNT = 20;

  private CountDownLatch latch = new CountDownLatch(COUNT);

  public CountDownLatch getLatch() {
    return latch;
  }

  @KafkaListener(id = "batch-listener", topics = "${kafka.topic.batch}")
  public void receive(List<ConsumerRecord<String, String>> list, Acknowledgment ack)  {
  //public void receive(ConsumerRecord<String, String> a)  {
    LOGGER.info("start of batch receive, batch size : " + list.size());
    for (int i = 0; i < list.size(); i++) {

      latch.countDown();
      ack.acknowledge();
    }
    LOGGER.info("end of batch receive");
  }
}
