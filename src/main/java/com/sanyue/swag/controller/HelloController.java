package com.sanyue.swag.controller;

import com.sanyue.swag.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author BoLin
 * @create 2020-10-20 17:23
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    //接口中，返回值只要有实体类，就会被扫描到swagger中
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }

    @ApiOperation("hello 实体类")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello2"+username;
    }

    @ApiOperation("post 测试类")
    @PostMapping("/postt")
    public User postt(@ApiParam("用户名") User user){
//        int i = 5/ 0;
        return user;
    }

}
