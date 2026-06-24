package com.ruoyi.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.ruoyi")
public class RuoYiWmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuoYiWmsApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  ruoyi-wms started   ლ(´ڡ`ლ)ﾞ");
    }
}
