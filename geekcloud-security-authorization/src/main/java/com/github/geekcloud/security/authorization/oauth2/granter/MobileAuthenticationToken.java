package com.github.geekcloud.security.authorization.oauth2.granter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

/**
 * @ClassName: MobileAuthenticationToken
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: 手机验证码登陆Token认证类
 */
public class MobileAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public MobileAuthenticationToken(Authentication authenticationToken) {
        super(authenticationToken.getPrincipal(), authenticationToken.getCredentials());
    }
}
