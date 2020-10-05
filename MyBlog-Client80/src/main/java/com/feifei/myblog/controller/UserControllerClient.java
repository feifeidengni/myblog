package com.feifei.myblog.controller;

import com.feifei.myblog.fegin.UserFeginClient;
import com.feifei.myblog.pojo.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
/**
 *      用户
 * */
@Controller
@RequestMapping("myblog/user/")
@Slf4j
public class UserControllerClient
{
    @Resource
    private UserFeginClient userFeginClient;

    /**
     *      登陆
     * */
    @PostMapping("/userAdmin")
    @ResponseBody
    public String login(@RequestParam("phone") String phone, @RequestParam("passWord") String passWord, HttpSession session){
        log.info("登陆信息：" + phone+"\t" + passWord);
        Admin admin = userFeginClient.AdminLogin(phone, passWord);
        if(admin != null){
            session.setAttribute("admin",admin);
            log.info("影响行数：" + admin);
            return "1";
        }
        return "0";
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session){
        session.invalidate();
        log.info("清除session:");
        return "1";
    }

    /**
     *      查询手机号是否重复
     * */
    @GetMapping("/phoneEq/{phone}")
    @ResponseBody
    public String doPhoneExist(@PathVariable("phone") String phone){
        String byPhone = userFeginClient.findByPhone(phone);
        log.info("手机号是否相同：" + byPhone);
        return byPhone;
    }

    /**
     *      注册用户信息
     * */
    @PostMapping("/save")
    @ResponseBody
    public Integer doSaveUser(@RequestParam(value = "phone" ) String phone,
                              @RequestParam(value = "passWord")String passWord,
                              @RequestParam(value = "name")String name){
        log.info("添加的用户数据：" + phone+";"+passWord+";"+name);
        Admin admin = new Admin();
        admin.setPhone(phone);
        admin.setPassWord(passWord);
        admin.setName(name);
        Integer count = userFeginClient.saveAdminUser(admin);
        log.info("添加影响的行数 ： " + count);
        return count;
    }









}
