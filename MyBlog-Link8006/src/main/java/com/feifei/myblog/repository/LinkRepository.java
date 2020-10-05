package com.feifei.myblog.repository;

import com.feifei.myblog.pojo.Link;

import java.util.List;

/**
 *      友链
 * */
public interface LinkRepository
{
    //查询所有友链。
    List<Link> findAll();
    //添加友链
    Integer saveLink(Link link);
    //更新友链
    Integer updateLink(Link link);
    //删除友链
    Integer deleteLink(Integer id);



}
