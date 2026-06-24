package com.ruoyi.common.datasource.config;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Re-export the dynamic-datasource auto-configuration so other services get the
 * full Spring Boot configuration with our common base class path.
 */
@Configuration
@Import(DynamicDataSourceAutoConfiguration.class)
public class DatasourceAutoConfig {
}
