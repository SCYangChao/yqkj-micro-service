package com.yqkj.micro.eruka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/**
 *
  * class_name: ErukaServiceApplication
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午12:15
  *
 **/
@EnableEurekaServer
@SpringBootApplication
@ComponentScan(basePackages = {"com.yqkj.config"})
public class MicroServiceErukaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceErukaApplication.class, args);
    }

}
