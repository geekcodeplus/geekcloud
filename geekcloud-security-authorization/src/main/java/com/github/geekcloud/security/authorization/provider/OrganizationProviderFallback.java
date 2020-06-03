package com.github.geekcloud.security.authorization.provider;

import com.github.geekcloud.framework.core.response.ResultWrapper;
import com.github.geekcloud.security.authorization.entity.Role;
import com.github.geekcloud.security.authorization.entity.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: OrganizationProviderFallback
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@Component
public class OrganizationProviderFallback implements OrganizationProvider {

    @Override
    public ResultWrapper<User> getUserByUniqueId(String uniqueId) {
        return ResultWrapper.success(new User());
    }

    @Override
    public ResultWrapper<Set<Role>> queryRolesByUserId(String userId) {
        return ResultWrapper.success(new HashSet<Role>());
    }
}
