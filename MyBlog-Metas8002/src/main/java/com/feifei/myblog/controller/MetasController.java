package com.feifei.myblog.controller;

import com.feifei.myblog.pojo.Metas;
import com.feifei.myblog.repository.MetasRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
/**
 *      项目
 * */
@RestController
@Slf4j
@RequestMapping("/myblog/metas")
public class MetasController
{
    @Resource
    private MetasRepository metasRepository;

    /**
     *  查询所有项目
     * */
    @GetMapping("/findAll")
    public List<Metas> findAllMetas(){
        List<Metas> metasList = metasRepository.findAll();
        log.info("总记录数： " + metasList.size());
        return metasList;
    }
    /**
     *  根据id查询当前项目
     * */
    @GetMapping("/findBymId/{mid}")
    public Metas findBymId(@PathVariable("mid") Integer mid){
        return metasRepository.findBymid(mid);
    }

    /**
     *  增加项目
     * */
    @PostMapping("/saveMetas")
    public Integer saveMetas(@RequestBody Metas metas ){
        metas.setCreateDate(new Date());
        log.info("添加信息：" + metas);
        Integer count = metasRepository.saveMetas(metas);
        return count;
    }
    /**
     *  修改项目
     * */
    @PutMapping("/updateMetas")
    public Integer updateMetas(@RequestBody Metas metas){
        log.info("修改信息：" + metas);
        Integer count = metasRepository.updateMetas(metas);
        return count;
    }
    /**
     *  删除项目
     * */
    @DeleteMapping("/deleteMetas/{mid}")
    public Integer deleteMetas(@PathVariable("mid") Integer mid){
        log.info("删除信息：" + mid);
        Integer count = metasRepository.deletetMetas(mid);
        return count;
    }


}
