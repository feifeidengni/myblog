package com.feifei.myblog.controller;

import com.feifei.myblog.pojo.Contents;
import com.feifei.myblog.repository.ContentRepository;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *      文章
 * */
@RestController
@RequestMapping("/myblog/contents")
@Slf4j
public class ContentsController
{

    @Resource
    private ContentRepository contentRepository;

    /**
     *  查询所有文章
     * */
    @GetMapping("/findAll")
    public List<Contents> findAll(){
        List<Contents> contentsList = contentRepository.findAll();
        log.info(contentsList.size()+"\t总记录数");
        return contentsList;
    }
    /**
     *  根据标题查询文章
     * */
    @GetMapping("/findByTitle")
    public List<Contents> findByTitle(@RequestParam String title){
        log.info("根据标题查询文章:" + title);
        List<Contents> list = contentRepository.findByTitle(title);
        return list;
    }
    /**
     *      根据分类id查询
     * */
    @GetMapping("/findByLabelId/{labelId}")
    public List<Contents> findByLabel(@PathVariable("labelId") Integer labelId){
        List<Contents> list = contentRepository.findByLabelId(labelId);
        return list;
    }
    /**
     *      根据点击率查询热门文章
     * */
    @GetMapping("/findByLook")
    public List<Contents> findByLook(){
        log.info("点击率查询文章");
        List<Contents> list = contentRepository.findByLook();
        return list;
    }
    /**
     *  根据文章id查询文章信息
     * */
    @GetMapping("/findByCid/{cid}")
    public Contents findByCid(@PathVariable("cid") Integer cid){
        Contents contents = contentRepository.findBycId(cid);
        return contents;
    }

    /**
     *  添加
     * */
    @PostMapping("saveContens")
    public Integer saveContents(@RequestBody Contents contents){
        contents.setCreateDate(new Date());
        Integer count = contentRepository.saveContents(contents);
        log.info("添加的影响行数： " + count);
        return count;
    }
    /**
     *  修改文章内容
     * */
    @PutMapping("/updateContents")
    public Integer updateContents(@RequestBody Contents contents){
        contents.setCreateDate(new Date());
        log.info("文章内容：" +contents);
        Integer count = contentRepository.updateContents(contents);
        return count;
    }
    /**
     *      增加点击率
     * */
    @GetMapping("/uplook/{cid}")
    public void updateLook(@PathVariable("cid") Integer cid){
        log.info("增加点击率的id:  " + cid);
        contentRepository.updateLook(cid);
    }

    /**
     *  删除
     * */
    @DeleteMapping("/deleteContents/{cid}")
    public Integer deleteContents(@PathVariable("cid") Integer cid){
        log.info("删除文章id:" + cid);
        Integer count = contentRepository.deleteContents(cid);
        return count;
    }

}
