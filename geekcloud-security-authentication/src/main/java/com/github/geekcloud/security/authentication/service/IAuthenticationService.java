package com.github.geekcloud.security.authentication.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: IAuthenticationService
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@Service
public interface IAuthenticationService {
    /**
     * 校验权限
     *
     * @param authRequest
     * @return 是否有权限
     */
    boolean decide(HttpServletRequest authRequest);

}
