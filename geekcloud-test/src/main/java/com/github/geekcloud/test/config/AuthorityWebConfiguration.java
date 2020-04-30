package com.github.geekcloud.test.config;

import com.github.geekcloud.framework.core.utils.SpringContextUtils;
import com.github.geekcloud.framework.log.event.SysLogListener;
import com.github.geekcloud.test.service.OptLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: AuthorityWebConfiguration
 * @author: jeffrey
 * @date: 2020年04月16日
 * @Description: TODO
 */
@Configuration
@Slf4j
public class AuthorityWebConfiguration {//extends BaseConfig {

    /**
     * Spring 工具类
     *
     * @param applicationContext
     * @return
     */
    @Bean
    public SpringContextUtils getSpringUtils(ApplicationContext applicationContext) {
        SpringContextUtils.setApplicationContext(applicationContext);
        return new SpringContextUtils();
    }

    /**
     * geekcloud.log.enabled = true 并且 geekcloud.log.type=DB时实例该类
     *
     * @param optLogService
     * @return
     */
    @Bean
    @ConditionalOnExpression("${geekcloud.log.enabled:true} && 'DB'.equals('${geekcloud.log.type:LOGGER}')")
    public SysLogListener sysLogListener(OptLogService optLogService) {
        log.info("------------AuthorityWebConfiguration---sysLogListener");
        return new SysLogListener((log) -> optLogService.save(log));
    }
}
