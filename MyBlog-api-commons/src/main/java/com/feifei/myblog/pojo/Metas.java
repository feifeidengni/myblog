package com.feifei.myblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *  项目
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Metas
{
    private Integer mid;        //主键编号
    private String name;        //项目名称
    private String mimg;        //图片地址
    private String url;        //项目访问路径
    private String type;        //项目的类型
    private Integer contentId;  //文章id
    private String description; //项目描述
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createDate;    //项目写作时间


}
