package com.ruoyi.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAdminServer
@SpringBootApplication
@EnableDiscoveryClient
public class RuoYiMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuoYiMonitorApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  ruoyi-monitor started   ლ(´ڡ`ლ)ﾞ");
    }
}
