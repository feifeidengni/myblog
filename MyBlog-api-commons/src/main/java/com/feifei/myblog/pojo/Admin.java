package com.feifei.myblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *  管理员用户登陆
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin
{
    private Integer aid;        //编号
    private String name;       //名称
    private String passWord;    //密码
    private String phone;       //手机
    private String mail;       //邮箱
    private Date createDate;    //创建时间

}
