package com.feifei.myblog.fegin;

import com.feifei.myblog.pojo.Comments;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *      评论
 * */
@FeignClient(value = "MYBLOGCOMMENTS")
public interface CommentsFeginClient {

    @GetMapping("/myblog/comments/findAll")
    public List<Comments> findAll();

    @GetMapping("/myblog/comments/findByparentId/{parentId}")
    public List<Comments> findByParentId(@PathVariable("parentId") Integer parentId);

    @PostMapping("/myblog/comments/saveComments")
    public Integer saveComments(@RequestBody Comments comments);

    @DeleteMapping("/myblog/comments/deleteComments/{commId}")
    public Integer deleteComments(@PathVariable("commId") Integer commId);


}
