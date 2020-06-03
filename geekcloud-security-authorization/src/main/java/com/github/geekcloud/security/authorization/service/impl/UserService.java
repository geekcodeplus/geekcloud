package com.github.geekcloud.security.authorization.service.impl;

import com.github.geekcloud.security.authorization.entity.User;
import com.github.geekcloud.security.authorization.provider.OrganizationProvider;
import com.github.geekcloud.security.authorization.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserService
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private OrganizationProvider organizationProvider;

    @Override
    public User getByUniqueId(String uniqueId) {
        return organizationProvider.getUserByUniqueId(uniqueId).getData();
    }
}
