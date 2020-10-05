package com.feifei.myblog.controller;


import com.feifei.myblog.pojo.Admin;
import com.feifei.myblog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RefreshScope
@Slf4j
@RequestMapping("/myblog/user")
public class UserControlller
{
    @Resource
    private UserRepository userRepository;

    /**
     *  登陆
     * */
    @GetMapping("/userAdmin/{phone}/{passWord}")
    public Admin AdminLogin (@PathVariable("phone") String phone,
                              @PathVariable("passWord") String passWord,
                              HttpSession session){
        //查询用户信息
        Admin admin = userRepository.findByPhoneAndPassWord(phone, passWord);
        return admin;
    }
    /**
     *  根据手机号查询用户信息
     * */
    @GetMapping("/findByPhone/{phone}")
    public String findByPhone(@PathVariable("phone") String phone){
        Admin admin = userRepository.findByPhone(phone);
        if(admin != null){
            return "exist";  //存在
        }
        return "NoExist";   //不存在
    }

    /**
     *  添加
     * */
    @PostMapping("/save")
    public Integer saveAdminUser(@RequestBody Admin admin){
        admin.setCreateDate(new Date());
        admin.setMail("123@qq.com");
        log.info("用户信息："+admin);
        Integer count = userRepository.saveAdminUser(admin);
        return count;
    }

    /**
     *  修改
     * */
    @PutMapping("/update")
    public Integer updateAdminUser(@RequestBody Admin admin){
        log.info("用户信息："+ admin);
        Integer count = userRepository.updateAdminUser(admin);
        return count;
    }

    /**
     *  删除
     * */
    @DeleteMapping("/deleteAdmin/{aid}")
    public Integer deleteAdminUser(@PathVariable("aid") Integer aid){
        log.info(aid+"\t删除用户的编号");
        Integer count = userRepository.deleteAdminUser(aid);
        return count;
    }


}
