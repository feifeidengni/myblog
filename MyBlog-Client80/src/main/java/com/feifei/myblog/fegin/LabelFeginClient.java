package com.feifei.myblog.fegin;

import com.feifei.myblog.pojo.Label;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *      标签
 * */
@FeignClient(value = "MYBLOGLABEL")
public interface LabelFeginClient {

    @GetMapping("/myblog/label/findAll")
    public List<Label> findAll();

    @PostMapping("/myblog/label/sabeLabel")
    public Integer saveLabel(@RequestBody Label label);

    @PutMapping("/myblog/label/updateLabel")
    public Integer updateLabel(@RequestBody Label label);

    @DeleteMapping("/myblog/label/deleteLabel/{id}")
    public Integer deleteLabel(@PathVariable("id") Integer id);

}
