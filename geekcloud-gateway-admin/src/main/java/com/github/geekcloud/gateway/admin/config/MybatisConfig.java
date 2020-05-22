package com.github.geekcloud.gateway.admin.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: MybatisConfig
 * @author: jeffrey
 * @date: 2020年05月21日
 * @Description: 初使化Mybatis审计字段自动赋值的interceptor
 */

@EnableTransactionManagement
@Configuration
public class MybatisConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
