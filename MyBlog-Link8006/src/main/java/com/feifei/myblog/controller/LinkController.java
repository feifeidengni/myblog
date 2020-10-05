package com.feifei.myblog.controller;

import com.feifei.myblog.pojo.Link;
import com.feifei.myblog.repository.LinkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *      友链
 * */
@RestController
@RequestMapping("/myblog/link")
@Slf4j
public class LinkController
{
    @Resource
    private LinkRepository linkRepository;

    /**
     *      查询所有友链
     * */
    @GetMapping("/findAll")
    public List<Link> findAll(){
        List<Link> list = linkRepository.findAll();
        return list;
    }
    /**
     *      新增友链
     * */
    @PostMapping("/saveLink")
    public Integer saveLink(@RequestBody Link link){
        log.info("添加友链数据： " +link);
        Integer count = linkRepository.saveLink(link);
        log.info("影响行数：" + count);
        return count;
    }
    /**
     *      修改友链
     * */
    @PutMapping("/updateLink")
    public Integer updateLink(@RequestBody Link link){
        log.info("修改友链数据： " +link);
        Integer count = linkRepository.updateLink(link);
        log.info("影响行数：" + count);
        return count;
    }

    /**
     *      删除友链
     * */
    @DeleteMapping("/deleteLink/{id}")
    public Integer deleteLink(@PathVariable("id")  Integer id){
        log.info("删除的id:" +id);
        Integer count = linkRepository.deleteLink(id);
        return count;
    }
}
