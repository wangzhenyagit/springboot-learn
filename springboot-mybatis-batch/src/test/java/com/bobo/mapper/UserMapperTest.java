package com.bobo.mapper;

import com.bobo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.swing.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    UserMapper userMapper;

    @Test
    @Transactional
    public void batchInsert() {
        User u1 = new User(1L, "zhangsan", 22);
        User u2 = new User(2L, "lisi", 33);
        List<User> users = new LinkedList<User>();
        users.add(u1);
        users.add(u2);

        userMapper.batchInsert(users);
        Assert.assertEquals(33, userMapper.findById(2L).getAge().intValue());
    }
}