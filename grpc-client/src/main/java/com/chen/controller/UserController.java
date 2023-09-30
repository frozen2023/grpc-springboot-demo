package com.chen.controller;

import com.alibaba.fastjson.JSONObject;
import com.chen.service.UserResponse;
import com.chen.service.UserServiceGrpc;
import com.chen.service.userIdRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GrpcClient("userClient")
    private UserServiceGrpc.UserServiceBlockingStub blockingStub;

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Integer id) {
        userIdRequest req = userIdRequest.newBuilder().setId(id).build();

        UserResponse resp = blockingStub.getUserById(req);

        return JSONObject.toJSONString(resp);
    }

}
