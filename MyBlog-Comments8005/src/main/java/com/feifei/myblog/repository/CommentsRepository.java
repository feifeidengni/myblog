package com.feifei.myblog.repository;

import com.feifei.myblog.pojo.Comments;

import java.util.List;

/**
 *      评论
 * */
public interface CommentsRepository
{
    //获取所有评论
    public List<Comments> findAll();
    //根据文章id查询当前文章的评论
    public List<Comments> findByParentId(Integer parentId);

    //添加评论
    Integer saveComments( Comments comments );

    //删除评论
    Integer deleteComments(Integer commId);


}
