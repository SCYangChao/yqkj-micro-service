package com.yqkj.log;

import com.yqkj.dto.LogDto;

/**
 *
  * class_name: ILogPersistentService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午11:40
  *
 **/
public interface ILogPersistentService {

    Boolean excute(LogDto logDto);

}
