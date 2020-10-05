package com.feifei.myblog.controller;

import com.feifei.myblog.fegin.CommentsFeginClient;
import com.feifei.myblog.pojo.Admin;
import com.feifei.myblog.pojo.Comments;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 *      评论
 * */
@Controller
@Slf4j
@RequestMapping("/myblog/comments")
public class CommentsController {
    @Resource
    private CommentsFeginClient commentsFeginClient;
    /**
     *  查询所有留言
     *
     * @return*/
    @GetMapping("/findAllComments")
    public String findAll(Model model){
         log.info("查询所有留言：");
        List<Comments> commentsList = commentsFeginClient.findAll();
        model.addAttribute("commentsList",commentsList);
        return "message";
    }

    /**
     *      添加评论
     * */
    @PostMapping("/saveComments")
    public String saveComments(HttpSession session, @RequestParam("editorContent") String editorContent,
                               @RequestParam(value = "parentId" ,required = false) Integer parentId){
        Admin admin = (Admin) session.getAttribute("admin");
        log.info("添加评论：" +editorContent + ";  " +parentId );
        Comments comments = new Comments();
        comments.setCreateDate(new Date());
        comments.setAuthor( admin.getName());
        comments.setText(editorContent);
        comments.setParentId(parentId);
        comments.setCreateDate(new Date());
        comments.setCommImg("/image/2.jpg");
        Integer count = commentsFeginClient.saveComments(comments);
        log.info("添加评论影响行数：" + count);
        if(parentId != null){
            return "redirect:/myblog/contents/findByCid/"+parentId;
        }
        return "redirect:findAllComments";
    }

    /**
     *      删除评论
     * */
    public void deleteComments(Integer commid){
        Integer count = commentsFeginClient.deleteComments(commid);
        log.info("删除评论id" + commid + ",影响行数： " + count);
    }







}
