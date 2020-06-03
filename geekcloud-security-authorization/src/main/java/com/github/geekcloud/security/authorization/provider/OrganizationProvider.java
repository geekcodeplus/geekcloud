package com.github.geekcloud.security.authorization.provider;

import com.github.geekcloud.framework.core.response.ResultWrapper;
import com.github.geekcloud.security.authorization.entity.Role;
import com.github.geekcloud.security.authorization.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 * @ClassName: OrganizationProvider
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@FeignClient(name = "organization", fallback = OrganizationProviderFallback.class)
public interface OrganizationProvider {

    @GetMapping(value = "/user")
    ResultWrapper<User> getUserByUniqueId(@RequestParam("uniqueId") String uniqueId);

    @GetMapping(value = "/role/user/{userId}")
    ResultWrapper<Set<Role>> queryRolesByUserId(@PathVariable("userId") String userId);
}
