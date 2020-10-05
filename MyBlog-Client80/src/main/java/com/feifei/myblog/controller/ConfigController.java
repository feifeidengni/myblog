package com.feifei.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConfigController
{

    @GetMapping("/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

}
