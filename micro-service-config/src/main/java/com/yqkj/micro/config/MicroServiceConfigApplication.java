package com.yqkj.micro.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *
  * class_name: MicroServiceConfigApplication
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午12:24
  *
 **/

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class MicroServiceConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceConfigApplication.class, args);
    }

}
