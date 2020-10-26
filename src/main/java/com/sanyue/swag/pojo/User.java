package com.sanyue.swag.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author BoLin
 * @create 2020-10-21 10:03
 */
@ApiModel("用户实体类")
public class User implements Serializable {
    @ApiModelProperty("用户名")
    public String name;
    @ApiModelProperty("年龄")
    public String age;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}
