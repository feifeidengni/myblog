package com.feifei.myblog.repository;

import com.feifei.myblog.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface UserRepository
{
    //根据手机号查询用户
    Admin findByPhoneAndPassWord(@Param("phone") String phone,@Param("passWord") String passWord);
    //根据手机号查询用户信息
    Admin findByPhone(String phone);

    //添加用户信息
    Integer saveAdminUser(Admin admin);
    //修改用户信息
    Integer updateAdminUser(Admin admin);
    //删除用户
    Integer deleteAdminUser(Integer aid);


}
