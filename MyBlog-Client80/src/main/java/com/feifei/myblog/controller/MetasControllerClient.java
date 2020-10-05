package com.feifei.myblog.controller;

import com.feifei.myblog.fegin.MetasFeginClient;
import com.feifei.myblog.pojo.Metas;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 *      项目
 * */
@Controller
@RequestMapping("/myblog/Metas")
public class MetasControllerClient
{
    @Resource
    private MetasFeginClient metasFeginClient;
    /**
     *      所有
     * */
    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Metas> metasList = metasFeginClient.findAllMetas();
        model.addAttribute("metasList",metasList);
        return "index";
    }
    /**
     *
     * */




}
