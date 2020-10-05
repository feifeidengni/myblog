package com.feifei.myblog.fegin;

import com.feifei.myblog.pojo.Metas;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *  项目
 * */
@FeignClient("MYBLOGMETAS")
public interface MetasFeginClient
{
    @GetMapping("/myblog/metas/findAll")
    public List<Metas> findAllMetas();

    @GetMapping("/myblog/metas/findBymId/{mid}")
    public Metas findBymId(@PathVariable("mid") Integer mid);

    @PostMapping("/myblog/metas/saveMetas")
    public Integer saveMetas(@RequestBody Metas metas );

    @PutMapping("/myblog/metas/updateMetas")
    public Integer updateMetas(@RequestBody Metas metas);

    @DeleteMapping("/myblog/metas/deleteMetas/{mid}")
    public Integer deleteMetas(@PathVariable("mid") Integer mid);

}
