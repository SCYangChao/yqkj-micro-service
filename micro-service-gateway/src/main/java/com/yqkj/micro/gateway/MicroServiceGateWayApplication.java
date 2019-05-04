package com.yqkj.micro.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.http.ZuulServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonRoutingFilter;
import org.springframework.web.servlet.DispatcherServlet;


/**
 *
  * class_name: MicroServiceGateWayApplication
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午4:41
  *
 **/
@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class MicroServiceGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceGateWayApplication.class, args);
    }

}
