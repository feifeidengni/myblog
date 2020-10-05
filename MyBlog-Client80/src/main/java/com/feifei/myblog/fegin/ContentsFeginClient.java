package com.feifei.myblog.fegin;

import com.feifei.myblog.pojo.Contents;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *      文章
 * */
@FeignClient(value = "MYBLOGCONTENTS")
public interface ContentsFeginClient {

    @GetMapping("/myblog/contents/findAll")
    public List<Contents> findAll();

    @GetMapping("/myblog/contents/findByTitle")
    public List<Contents> findByTitle(@RequestParam("title") String title);

    @GetMapping("/myblog/contents/findByLabelId/{labelId}")
    public List<Contents> findByLabel(@PathVariable("labelId") Integer labelId);

    @GetMapping("/myblog/contents/findByLook")
    public List<Contents> findByLook();

    @GetMapping("/myblog/contents/findByCid/{cid}")
    public Contents findByCid(@PathVariable("cid") Integer cid);

    @PostMapping("/myblog/contents/saveContens")
    public Integer saveContents(@RequestBody Contents contents);

    @PutMapping("/myblog/contents/updateContents")
    public Integer updateContents(@RequestBody Contents contents);

    @GetMapping("/myblog/contents/uplook/{cid}")
    public void updateLook(@PathVariable("cid") Integer cid);

    @DeleteMapping("/myblog/contents/deleteContents/{cid}")
    public Integer deleteContents(@PathVariable("cid") Integer cid);


}
