package com.yqkj.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Objects;

/**
 *
  * class_name: Response
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午10:20
  *
 **/
@ApiModel
@Data
public class Response<T> {

    /**
     * true 成功 false 失敗
     */
    private Boolean status = true;

    /**
     * 業務編碼
     */
    private Integer code = Integer.valueOf(200);
    /**
     * 異常信息
     */
    private String msg = "處理成功";

    private T data;

    public  Response error(Integer code , String msg) {

        if (Objects.isNull(code)) {
            code = 500;
        }
        this.msg = msg;
        this.code = code;
        return  this;
    }
    public  Response error( String msg) {
        this.msg = msg;
        return  this;
    }

    public  Response success(T t) {
        this.data =t;
        return  this;
    }

}
