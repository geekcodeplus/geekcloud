package com.github.geekcloud.security.authentication.provider;

import com.github.geekcloud.framework.core.response.ResultWrapper;
import com.github.geekcloud.security.authentication.entity.po.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: ResourceProviderFallback
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@Component
@Slf4j
public class ResourceProviderFallback implements ResourceProvider {
    @Override
    public ResultWrapper<Set<Resource>> resources() {
        log.error("认证服务启动时加载资源异常！未加载到资源");
        return ResultWrapper.success(new HashSet<Resource>());
    }

    @Override
    public ResultWrapper<Set<Resource>> resources(String username) {
        log.error("认证服务查询用户异常！查询用户资源为空！");
        return ResultWrapper.success(new HashSet<Resource>());
    }
}

