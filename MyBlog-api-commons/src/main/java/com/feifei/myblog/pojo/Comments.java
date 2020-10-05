package com.feifei.myblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
/**
 *  评论
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
    private Integer commId;         //评论主键
    private String author;          //评论者名称
    private String text;            //评论内容
    private Integer parentId;       //父类评论id
    private String commImg;         //评论者头像路径
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;        //评论时间

}
