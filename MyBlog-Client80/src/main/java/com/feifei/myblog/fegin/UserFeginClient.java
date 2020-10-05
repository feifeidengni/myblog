package com.feifei.myblog.fegin;

import com.feifei.myblog.pojo.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
/**
 *      用户
 * */
@FeignClient(value = "MYBLOGUSER")
public interface UserFeginClient
{
    @GetMapping("myblog/user/userAdmin/{phone}/{passWord}")
    public Admin AdminLogin (@PathVariable("phone") String phone,
                              @PathVariable("passWord") String passWord);

    @GetMapping("/myblog/user/findByPhone/{phone}")
    public String findByPhone(@PathVariable("phone") String phone);

    @PostMapping("/myblog/user/save")
    public Integer saveAdminUser(@RequestBody Admin admin);

    @PutMapping("/myblog/user/update")
    public Integer updateAdminUser(@RequestBody Admin admin);

    @DeleteMapping("/myblog/user/deleteAdmin/{aid}")
    public Integer deleteAdminUser(@PathVariable("aid") Integer aid);
}
