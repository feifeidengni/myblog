package com.feifei.myblog.controller;

import com.feifei.myblog.pojo.Label;
import com.feifei.myblog.repository.LabelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *      分类
 * */
@RestController
@RequestMapping("/myblog/label")
@Slf4j
public class LabelController
{
    @Resource
    private LabelRepository labelRepository;
    /**
     *  查询所有分类
     * */
    @GetMapping("/findAll")
    public List<Label> findAll(){
        List<Label> list = labelRepository.findAll();
        return list;
    }

    /**
     *  新增分类
     * */
    @PostMapping("/sabeLabel")
    public Integer saveLabel(@RequestBody Label label){
        Integer count = labelRepository.saveLabel(label);
        log.info("新增分类：" + count);
        return count;
    }
    /**
     *      修改分类
     * */
    @PutMapping("/updateLabel")
    public Integer updateLabel(@RequestBody Label label){
        Integer count = labelRepository.updateLabel(label);
        log.info("修改分类：" +count);
        return count;
    }

    /**
     *  删除分类
     * */
    @DeleteMapping("/deleteLabel/{id}")
    public Integer deleteLabel(@PathVariable("id") Integer id){
        Integer count = labelRepository.deleteLabel(id);
        log.info("删除分类：" + count);
        return count;
    }


}
