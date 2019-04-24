package com.yqkj.exception;

import lombok.Data;

/**
  * class_name: ParamIotException
  * package: com.xhs.iot.common.exception
  * describe: TODO
  * @author: yangchao
  * creat_date: 上午9:33
 **/


@Data
public class ParamException extends YqkjException {

    public ParamException(String msg ) {
        super(SYS_EXCEPTION_CODE, msg);
    }

}
