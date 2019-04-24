package com.yqkj.log;


import java.lang.annotation.*;


/**
 *
  * class_name: WriteLog
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午9:54
  *
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WriteLog {

    String model() default "sys";

    String tile() default  "";

}
