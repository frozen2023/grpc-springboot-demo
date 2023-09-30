package com.chen.controller;

import com.chen.service.UserServiceGrpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javafx.scene.layout.Background;
import org.springframework.web.bind.annotation.*;
import sun.security.acl.WorldGroupImpl;

@RestController
@Api(tags = "用户管理")
public class UserController {

    @PostMapping("/user")
    @ApiOperation("增加用户")
    public String addUser(@ApiParam("用户实体") @RequestBody String user) {
        return "增加了一个用户!";
    }

    @GetMapping("/user")
    @ApiOperation("查询用户")
    public String getUser(@ApiParam("用户id") @RequestParam("id") Integer id) {
        return "查询到id为" + id + "的用户";
    }



}
