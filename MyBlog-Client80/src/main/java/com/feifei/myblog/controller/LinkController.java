package com.feifei.myblog.controller;

import com.feifei.myblog.fegin.LinkFeginClient;
import com.feifei.myblog.pojo.Link;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/myblog/link")
public class LinkController
{
    @Resource
    private LinkFeginClient linkFeginClient;

    /**
     *      查询所有友链
     *
     * @return*/
    @GetMapping("findAll")
    public String findAll(Model model){
        List<Link> linkList = linkFeginClient.findAll();
        model.addAttribute("linkList",linkList);
        return "link";
    }

    /**
     *      新增友链
     *
     * @return*/
    @PostMapping("/saveLink")
    public java.lang.String saveLink(@RequestBody Link link){
         log.info("添加友链信息：" + link);
        Integer count = linkFeginClient.saveLink(link);
        log.info("影响行数：" + count);
        return "";
    }
    //修改友链
    @PutMapping("/updateLink")
    public String updateLink(@RequestBody Link link){
        log.info("更新友链信息：" + link);
        Integer count = linkFeginClient.updateLink(link);
        log.info("影响行数：" + count);
        return "";
    }

    @GetMapping("/deleteLink/{id}")
    public String deleteLink(@PathVariable("id") Integer id){
        log.info("删除友链信息：" + id);
        Integer count = linkFeginClient.deleteLink(id);
        log.info("影响行数：" + count);
         return "";
    }
}
