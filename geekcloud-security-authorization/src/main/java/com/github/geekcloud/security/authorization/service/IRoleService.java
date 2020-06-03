package com.github.geekcloud.security.authorization.service;

import com.github.geekcloud.security.authorization.entity.Role;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @ClassName: IRoleService
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@Service
public interface IRoleService {

    Set<Role> queryUserRolesByUserId(String userId);

}

