package com.github.geekcloud.framework.log;

import org.slf4j.MyMDCAdapter;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author： jeffrey
 * @date： 2020/4/12
 * @description： 初始化TtlMDCAdapter实例，并替换MDC中的adapter对象
 * @modified By：
 * @version: 1.0.0
 */
public class MyMDCAdapterInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        //加载TtlMDCAdapter实例
        MyMDCAdapter.getInstance();
    }
}
