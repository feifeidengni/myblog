package com.feifei.myblog.controller;
import com.feifei.myblog.pojo.Comments;
import com.feifei.myblog.repository.CommentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
/**
 *      评论
 * */
@RestController
@RequestMapping("/myblog/comments")
@Slf4j
public class CommentsController
{
    @Resource
    private CommentsRepository commentsRepository;

    /**
     *  查询所有评论
     * */
    @GetMapping("/findAll")
    public List<Comments> findAll(){
        List<Comments> list = commentsRepository.findAll();
        return list;
    }
    /**
     *  根据文章id查询当前评论
     * */
    @GetMapping("/findByparentId/{parentId}")
    public List<Comments> findByParentId(@PathVariable("parentId") Integer parentId){
        List<Comments> listComments = commentsRepository.findByParentId(parentId);
        return listComments;
    }

    /**
     *  添加评论
     * */
    @PostMapping("/saveComments")
    public Integer saveComments(@RequestBody Comments comments){
        log.info("添加数据：" +comments);
        Integer count = commentsRepository.saveComments(comments);
        log.info("添加评论影响行数：" + count);
        return count;
    }

    /**
     * 删除评论
     * */
    @DeleteMapping("/deleteComments/{commId}")
    public Integer deleteComments(@PathVariable("commId") Integer commId){
        log.info("删除评论：" + commId);
        Integer count = commentsRepository.deleteComments(commId);
        return count;
    }

}
