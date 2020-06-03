package com.github.geekcloud.gateway.web.service;

/**
 * @ClassName: IPermissionService
 * @author: jeffrey
 * @date: 2020年05月26日
 * @Description: 签权服务
 */
public interface IPermissionService {
    /**
     * @param authentication
     * @param method
     * @param url
     * @return
     */
    boolean permission(String authentication, String url, String method);
}
