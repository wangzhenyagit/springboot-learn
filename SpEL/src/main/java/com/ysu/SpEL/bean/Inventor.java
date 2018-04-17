package com.ysu.SpEL.bean;

import lombok.Data;

@Data
public class Inventor {
    String name;

    public Inventor(String name) {
        this.name = name;
    }
}
