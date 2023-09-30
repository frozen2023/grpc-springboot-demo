package com.chen.service;

import com.chen.entity.User;
import com.chen.mapper.UserMapper;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import javax.annotation.Resource;

@GrpcService
public class UserGrpcService extends UserServiceGrpc.UserServiceImplBase {

    @Resource
    private UserMapper userMapper;

    @Override
    public void getUserById(userIdRequest request, StreamObserver<UserResponse> responseObserver) {
        int id = request.getId();
        User user = userMapper.selectById(id);
        UserResponse userResp = UserResponse.newBuilder().setId(user.getId()).setName(user.getName()).build();
        responseObserver.onNext(userResp);
        responseObserver.onCompleted();
    }
}
