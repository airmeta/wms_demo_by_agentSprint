package com.ruoyi.common.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.ruoyi.common.core.exception",
        "com.ruoyi.common.core.utils"
})
public class CoreAutoConfig {
}
