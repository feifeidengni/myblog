package com.feifei.myblog.controller;

import com.feifei.myblog.fegin.CommentsFeginClient;
import com.feifei.myblog.fegin.ContentsFeginClient;
import com.feifei.myblog.fegin.LabelFeginClient;
import com.feifei.myblog.pojo.Comments;
import com.feifei.myblog.pojo.Contents;
import com.feifei.myblog.pojo.Label;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
/**
 *      文章
 * */
@Controller
@Slf4j
@RequestMapping("/myblog/contents")
public class ContentsController
{
    @Resource
    private ContentsFeginClient contentsFeginClient;
    @Resource
    private LabelFeginClient labelFeginClient;
    @Resource
    private CommentsFeginClient commentsFeginClient;

    /**
     *      查询所有文章
     *
     * @return*/
    @GetMapping("/findAllContents")
    public java.lang.String findAllContents(Model model ){
        List<Contents> contentsList = contentsFeginClient.findAll();
        List<Label> labelList = labelFeginClient.findAll();
        List<Contents> lookList = contentsFeginClient.findByLook();
        model.addAttribute("lookList",lookList);
        model.addAttribute("contentsList",contentsList);
        model.addAttribute("labelList",labelList);
        for (Contents contents: contentsList ) {
            System.out.println(contents.getTitle());
            System.out.println(contents.getLabel().getLabelName());
        }
        return "article";
    }
    /**
     *      根据标题查询
     *
     * @return*/
    @GetMapping("/findByTitle")
    public java.lang.String findByTitle(@RequestParam("title") String title, Model model){
        List<Contents> contentsList = contentsFeginClient.findByTitle(title);
        List<Label> labelList = labelFeginClient.findAll();
        List<Contents> lookList = contentsFeginClient.findByLook();
        model.addAttribute("lookList",lookList);
        model.addAttribute("contentsList",contentsList);
        model.addAttribute("labelList",labelList);
        return "article";
    }
    /**
     *      根据分类查询
     *
     * @return*/
    @GetMapping("/fingByLabelId")
    public java.lang.String fingByLabelId(@RequestParam("labelId") Integer labelId, Model model){
        log.info("分类查询：" + labelId);
        List<Contents> contentsList = contentsFeginClient.findByLabel(labelId);
        List<Label> labelList = labelFeginClient.findAll();
        List<Contents> lookList = contentsFeginClient.findByLook();
        model.addAttribute("lookList",lookList);
        model.addAttribute("labelList",labelList);
        model.addAttribute("contentsList",contentsList);
        return "article";
    }

    /**
     *      增加点击率
     *
     * @return*/
    @GetMapping("/uplook")
    public java.lang.String updateLook(@RequestParam("cid") Integer cid){
        log.info("点击率增加：-----" +cid);
        contentsFeginClient.updateLook(cid);
        return "redirect:findByCid/"+cid;
    }
    /**
     *      根据文章id查询
     * */
    @GetMapping("/findByCid/{cid}")
    public String findByCid(@PathVariable("cid") Integer cid,Model model){
        Contents contents = contentsFeginClient.findByCid(cid);
        model.addAttribute("contents",contents);
        List<Comments> commentsList = commentsFeginClient.findByParentId(cid);
        model.addAttribute("commentsList",commentsList);
        return "read";
    }

    /**
     *      添加文章
     * */
    @PostMapping("/saveContents")
    public void saveContents(Contents contents){
        log.info("添加文章：" + contents);
        Integer count = contentsFeginClient.saveContents(contents);
        log.info("影响行数：" + count);
    }

    /**
     *      修改文章
     * */
    @PutMapping("/updateContents")
    public void updateContents(Contents contents){
        log.info("修改文章：    " +contents );
        Integer count = contentsFeginClient.updateContents(contents);
        log.info("影响行数：" + count);
    }

    /**
     *      删除文章
     * */
    public void deleteConetens(Integer cid){
        log.info("删除文章id" + cid);
        Integer count = contentsFeginClient.deleteContents(cid);
        log.info("影响行数：" + count);
    }

}
