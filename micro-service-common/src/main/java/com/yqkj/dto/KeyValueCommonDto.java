package com.yqkj.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *
  * describe: do
 * class_name: KeyValueCommonDto
 * @author: yangchao.cool@gmail.com
  * creat_date: 下午11:32
  *
 **/
@Data
@ApiModel
public class KeyValueCommonDto implements Serializable {

    @ApiModelProperty("key")
    private String key;

    @ApiModelProperty("值")
    private String value;

}
