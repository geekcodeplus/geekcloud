package com.github.geekcloud.security.authentication.provider;

import com.github.geekcloud.framework.core.response.ResultWrapper;
import com.github.geekcloud.security.authentication.entity.po.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

/**
 * @ClassName: ResourceProvider
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@FeignClient(name = "organization", fallback = ResourceProviderFallback.class)
public interface ResourceProvider {

    @GetMapping(value = "/resource/all")
    ResultWrapper<Set<Resource>> resources();

    @GetMapping(value = "/resource/user/{username}")
    ResultWrapper<Set<Resource>> resources(@PathVariable("username") String username);
}
