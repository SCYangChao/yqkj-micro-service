package com.yqkj.constant;

import java.util.Objects;

/**
 *
  * class_name: GloabEnum
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午6:04
  *
 **/
public interface GloabEnum {

    /**
     * 用戶類型
     */
    enum UserType implements GloabEnum {

        ADMIN(1) ,NORMAL(0);

        private Integer type;

        UserType(Integer type) {
            this.type=type;
        }

        public  static  Boolean isAdmin(Integer type) {
            if (Objects.isNull(type)) {
                return Boolean.FALSE;
            }

//            return  ADMIN.type.compareTo(type) ==0;

            return Boolean.TRUE;
        }

    }

}
