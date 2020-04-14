package com.github.geekcloud.framework.log;


import com.alibaba.fastjson.JSONObject;
import com.github.geekcloud.framework.log.aspect.SysLogAspect;
import com.github.geekcloud.framework.log.event.SysLogListener;
import com.github.geekcloud.framework.log.interceptor.MdcMvcConfigurer;
import com.github.geekcloud.framework.log.monitor.PointUtil;
import com.github.geekcloud.framework.log.properties.OptLogProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author： jeffrey
 * @date： 2020/4/12
 * @description：
 * 日志自动配置
 *  * <p>
 *  * 启动条件：
 *  * 1，存在web环境
 *  * 2，配置文件中geekcloud.log.enabled=true 或者 配置文件中不存在：geekcloud.log.enabled 值
 *
 *
 * @modified By：
 * @version: 1.0.0
 */
@EnableAsync
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = OptLogProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class LogAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SysLogAspect sysLogAspect() {
        return new SysLogAspect();
    }

    @Bean
    public MdcMvcConfigurer getMdcMvcConfigurer() {
        return new MdcMvcConfigurer();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnExpression("${geekcloud.log.enabled:true} && 'LOGGER'.equals('${geekcloud.log.type:LOGGER}')")
    public SysLogListener sysLogListener() {
        return new SysLogListener((log) -> {
            PointUtil.debug("0", "OPT_LOG", JSONObject.toJSONString(log));
        });
    }
}
