package com.feifei.myblog.fegin;

import com.feifei.myblog.pojo.Link;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(value = "MYBLOGLINK")
public interface LinkFeginClient
{
    /**
     *      查询所有友链
     * */
    @GetMapping("/myblog/link/findAll")
    public List<Link> findAll();


    /**
     *      新增友链
     * */
    @PostMapping("/saveLink")
    public Integer saveLink(@RequestBody Link link);


    /**
     *      修改友链
     * */
    @PutMapping("/updateLink")
    public Integer updateLink(@RequestBody Link link);

    /**
     *      删除友链
     * */
    @DeleteMapping("/deleteLink/{id}")
    public Integer deleteLink(@PathVariable("id")  Integer id);



}
