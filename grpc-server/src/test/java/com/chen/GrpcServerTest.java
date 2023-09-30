package com.chen;

import com.chen.entity.User;
import com.chen.mapper.UserMapper;
import com.sun.media.sound.SoftTuning;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class GrpcServerTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        userMapper.insert(new User(1, "frozen"));

        User user = userMapper.selectById(1);
        System.out.println(user);
    }
}
