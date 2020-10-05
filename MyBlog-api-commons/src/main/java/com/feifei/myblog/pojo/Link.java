package com.feifei.myblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  友链
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private Integer id;     //主键
    private String name;    //友链名称
    private String imgURL;   //头像地址
    private String sketch;  //友链简述
    private String url;     //url地址
}
