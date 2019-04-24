package com.yqkj.utile;

import com.yqkj.dto.Response;

/**
 *
  * class_name: ResponseToole
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午10:27
  *
 **/
public class ResponseToole {

    /**
     * 構建默認的返回親求
     * @param t
     * @param <T>
     * @return
     */
    public  static <T> Response<T> success(T t) {
        Response<T> response = new Response<>();
        return response.success(t);
    }

    /**
     * 構建默認的返回親求
     * @param <T>
     * @return
     */
    public  static <T> Response<T> error(Integer code ,String msg) {
        Response<T> response = new Response<>();
        return response.error(code, msg);
    }
}
