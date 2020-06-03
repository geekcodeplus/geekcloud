package com.github.geekcloud.gateway.web.service.impl;

import com.github.geekcloud.gateway.web.service.IPermissionService;
import com.github.geekcloud.security.client.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: PermissionService
 * @author: jeffrey
 * @date: 2020年05月26日
 * @Description: 签权服务
 */
@Service
public class PermissionService implements IPermissionService {

    /**
     * 由authentication-client模块提供签权的feign客户端
     */
    @Autowired
    private IAuthService authService;

    @Override
//    @Cached(name = "gateway_auth::", key = "#authentication+#method+#url",
//            cacheType = CacheType.LOCAL, expire = 10, timeUnit = TimeUnit.SECONDS, localLimit = 10000)
    public boolean permission(String authentication, String url, String method) {
        return authService.hasPermission(authentication, url, method);
    }
}
