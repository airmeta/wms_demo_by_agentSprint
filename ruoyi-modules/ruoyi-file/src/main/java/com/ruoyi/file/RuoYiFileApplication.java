package com.ruoyi.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.ruoyi")
public class RuoYiFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuoYiFileApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  ruoyi-file started   ლ(´ڡ`ლ)ﾞ");
    }
}
