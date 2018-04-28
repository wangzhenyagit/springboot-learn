package com.bobo.springbootrest.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GreetingControllerTest {

    @Test
    public void greeting() {
        RestTemplate restTemplate = new RestTemplate();
        Greeting greeting = restTemplate.getForObject("http://localhost:8080/greeting", Greeting.class);
        Assert.notNull(greeting, "greet null.");
        System.out.println(greeting);
    }
}