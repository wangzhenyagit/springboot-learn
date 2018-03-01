package com.bobo.mapper;

import com.bobo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User findById(Long id);

    int batchInsert(List<User> users);
}
