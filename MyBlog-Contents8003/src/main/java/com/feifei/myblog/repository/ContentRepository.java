package com.feifei.myblog.repository;

import com.feifei.myblog.pojo.Contents;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 *             文章
 * */
public interface ContentRepository
{
        //查询所有文章
        List<Contents> findAll();
        //根据文章标题查询
        List<Contents> findByTitle(@Param("title") String title);
        //根据分类id查询
        List<Contents> findByLabelId(Integer labelId);
        //根据点击率查询热门文章
        List<Contents> findByLook();
        //根据文章id查询文章
        Contents findBycId(Integer cid);
        //添加文章
        Integer saveContents(Contents contents);
        //点击文章增加点击率
        void updateLook(Integer cid);
        //修改文章
        Integer updateContents(Contents contents);
        //删除文章
        Integer deleteContents(Integer cid);




}
