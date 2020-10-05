package com.feifei.myblog.repository;

import com.feifei.myblog.pojo.Metas;

import java.util.List;
/**
 *      项目
 * */
public interface MetasRepository
{
    //查询所有的项目
    public List<Metas> findAll();
    //根据id查询当前项目
    public Metas findBymid(Integer mid);
    //添加项目
    public Integer saveMetas(Metas metas);
    //修改项目
    public Integer updateMetas(Metas metas);
    //删除项目
    public Integer deletetMetas(Integer mid);


}
