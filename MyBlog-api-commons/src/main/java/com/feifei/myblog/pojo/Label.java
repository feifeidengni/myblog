package com.feifei.myblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  标签
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Label {
    private Integer id; //编号
    private String labelName;   //标签名称
}
