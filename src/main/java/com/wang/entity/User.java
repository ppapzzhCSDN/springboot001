package com.wang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data  //等同于get和set
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("用户实体类")
public class User implements Serializable {

    @ApiModelProperty(value = "用户id",required = true)
    private String id;
    @ApiModelProperty(value = "用户姓名",required = true)
    private String name;
    @ApiModelProperty(value = "用户密码",required = true)
    private String password;
    @ApiModelProperty(value ="用户年龄",required = true)
    private Integer age;
    @ApiModelProperty(value ="用户性别",required = true)
    private String sex;
    @ApiModelProperty(value ="创建时间",required = true)
    private String  createTime;

}
