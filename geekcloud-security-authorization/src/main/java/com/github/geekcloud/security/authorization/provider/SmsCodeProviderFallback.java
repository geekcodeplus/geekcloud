package com.github.geekcloud.security.authorization.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName: SmsCodeProviderFallback
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@Component
public class SmsCodeProviderFallback implements SmsCodeProvider {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String getSmsCode(String mobile, String businessType) {
        // 该类为mock, 目前暂时没有sms的服务
        return passwordEncoder.encode("123456");
    }
}

