package com.github.geekcloud.security.authorization.service.impl;

import com.github.geekcloud.security.authorization.entity.Role;
import com.github.geekcloud.security.authorization.provider.OrganizationProvider;
import com.github.geekcloud.security.authorization.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @ClassName: RoleService
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@Service
public class RoleService implements IRoleService {

    @Autowired
    private OrganizationProvider organizationProvider;

    @Override
    public Set<Role> queryUserRolesByUserId(String userId) {
        return organizationProvider.queryRolesByUserId(userId).getData();
    }

}

