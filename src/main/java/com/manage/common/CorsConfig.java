package com.manage.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @project：springboot_vue
 * @since：2025/5/22 11:10
 * @author：wzx
 */
@Configuration
public class CorsConfig {

    /**
     * 配置跨域资源共享(CORS)过滤器
     * 允许所有来源、请求头和HTTP方法访问所有路径
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许所有来源
        corsConfiguration.addAllowedOrigin("*");
        // 允许所有请求头
        corsConfiguration.addAllowedHeader("*");
        // 允许所有HTTP方法
        corsConfiguration.addAllowedMethod("*");
        // 应用到所有路径
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}
