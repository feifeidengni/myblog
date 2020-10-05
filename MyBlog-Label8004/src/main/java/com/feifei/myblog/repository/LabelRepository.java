package com.feifei.myblog.repository;

import com.feifei.myblog.pojo.Label;

import java.util.List;
/**
 *      分类
 * */
public interface LabelRepository
{
    //查询所有分类
    List<Label> findAll();
    //根据id查询
    Label findById(Integer labelId);
    //增加文章分类
    Integer saveLabel(Label label);
    //修改分类
    Integer updateLabel(Label label);
    //删除分类
    Integer deleteLabel(Integer id);


}
