package com.yqkj.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 *
  * class_name: LogDto
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午10:15
  *
 **/
@Data
@ApiModel
public class LogDto implements Serializable {

    @ApiModelProperty("日誌時間")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "logTime不能爲空")
    private Date logTime;

    @ApiModelProperty("接口耗時")
    @NotNull(message = "costTime　不能爲空")
    private Integer costTime;

    @ApiModelProperty("IP")
    @NotNull(message = "ip　不能爲空")
    private String ip;
    /**
     * 日志类型
     */
    @ApiModelProperty("日誌模塊編碼")
    @NotNull(message = "model 　不能爲空")
    private String model;
    /**
     * 日誌信息
     */
    @ApiModelProperty("日誌操作詳情")
    @NotNull(message = "title 不能爲空")
    private String title;
    /**
     * 请求URI
     */
    @ApiModelProperty("请求URI")
    @NotNull(message = "requestUri 不能爲空")
    private String requestUri;
    /**
     * 操作方式
     */
    @ApiModelProperty("操作方式")
    @NotNull(message = "method 不能爲空")
    private String method;
    /**
     * 操作提交的数据
     */
    @ApiModelProperty("操作提交的数据")
    @Length(max = 2048 ,message = "异常信息信息最大長度2048個字符")
    private String params;
    /**
     *
     */
    @ApiModelProperty("狀態　200　500")
    @NotNull(message = "resultStatus 不能爲空")
    private Integer resultStatus;
    /**
     * 异常信息
     */
    @ApiModelProperty("异常信息")
    @Length(max = 1024 ,message = "异常信息信息最大長度1024個字符")
    private String exception;
    @ApiModelProperty("用戶")
    private String createBy;

}
