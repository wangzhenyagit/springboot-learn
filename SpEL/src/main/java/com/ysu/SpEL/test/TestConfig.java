package com.ysu.SpEL.test;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Data
public class TestConfig {
    @Value("#{${config.random}}")
    Double random;

    @Value("#{${config.map}}")
    Map<String, String> map;

    // 类型是String和Integer都可以
    @Value("#{'${config.list}'.split(',')}")
    List<Integer> list;
}
