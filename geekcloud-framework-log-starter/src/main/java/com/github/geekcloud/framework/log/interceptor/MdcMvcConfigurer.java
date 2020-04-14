package com.github.geekcloud.framework.log.interceptor;

import lombok.AllArgsConstructor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author： jeffrey
 * @date： 2020/4/12
 * @description： 公共配置类, 一些公共工具配置
 * @modified By：
 * @version: 1.0.0
 */
@AllArgsConstructor
public class MdcMvcConfigurer implements WebMvcConfigurer {

    /**
     * 注册 拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MdcHandlerInterceptor())
                .addPathPatterns("/**")
                .order(-18);
    }
}
