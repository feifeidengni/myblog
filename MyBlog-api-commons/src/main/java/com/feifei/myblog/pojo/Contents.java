package com.feifei.myblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 *  文章
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contents
{
    private Integer cid;     //主键
    private String title;   //标题
    private String slug;    //内容缩写
    private String text;    //内容文字
    private String type;    //内容类别
    private Integer look;   //查看次数
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createDate;//创建日期
    private Label label;    //标签
    private Integer stick;  //是否置顶

}
