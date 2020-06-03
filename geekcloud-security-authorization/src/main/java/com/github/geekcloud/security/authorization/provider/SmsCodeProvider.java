package com.github.geekcloud.security.authorization.provider;

/**
 * @ClassName: SmsCodeProvider
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * todo 实现短信验证码的服务
 */
//@FeignClient(name = "sms", fallback = OrganizationProviderFallback.class)
public interface SmsCodeProvider {

    /**
     * @param mobile
     * @return
     */
    @GetMapping(value = "/sms/{mobile}")
    String getSmsCode(@PathVariable("mobile") String mobile, @RequestParam("businessType") String businessType);
}

