package com.yqkj.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
  * class_name: SecurityConfiguration
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午3:37
  *
 **/

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests()

                .anyRequest()

                .permitAll()

                .and()

                .csrf()

                .disable();
    }
}
