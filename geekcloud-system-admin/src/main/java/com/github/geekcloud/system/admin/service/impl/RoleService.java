package com.github.geekcloud.system.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.geekcloud.system.admin.dao.RoleMapper;
import com.github.geekcloud.system.admin.entity.param.RoleQueryParam;
import com.github.geekcloud.system.admin.entity.po.Role;
import com.github.geekcloud.system.admin.service.IRoleResourceService;
import com.github.geekcloud.system.admin.service.IRoleService;
import com.github.geekcloud.system.admin.service.IUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @ClassName: RoleService
 * @author: jeffrey
 * @date: 2020年05月29日
 * @Description: TODO
 */
@Service
@Slf4j
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IRoleResourceService roleResourceService;

    @Override
    public boolean add(Role role) {
        boolean isSuccess = this.save(role);
        roleResourceService.saveBatch(role.getId(), role.getResourceIds());
        return isSuccess;
    }

    @Override
    //@CacheInvalidate(name = "role::", key = "#id")
    public boolean delete(String id) {
        roleResourceService.removeByRoleId(id);
        return this.removeById(id);
    }

    @Override
    //@CacheInvalidate(name = "role::", key = "#role.id")
    public boolean update(Role role) {
        boolean isSuccess = this.updateById(role);
        roleResourceService.saveBatch(role.getId(), role.getResourceIds());
        return isSuccess;
    }

    @Override
    //@Cached(name = "role::", key = "#id", cacheType = CacheType.BOTH)
    public Role get(String id) {
        Role role = this.getById(id);
        if (Objects.isNull(role)) {
            try {
                throw new RoleNotFoundException("role not found with id:" + id);
            } catch (RoleNotFoundException e) {
                e.printStackTrace();
            }
        }
        role.setResourceIds(roleResourceService.queryByRoleId(id));
        return role;
    }

    @Override
    public List<Role> getAll() {
        return this.list();
    }

    @Override
    //@Cached(name = "role4user::", key = "#userId", cacheType = CacheType.BOTH)
    public List<Role> query(String userId) {
        Set<String> roleIds = userRoleService.queryByUserId(userId);
        return (List<Role>) this.listByIds(roleIds);
    }

    @Override
    public IPage<Role> query(Page page, RoleQueryParam roleQueryParam) {
        QueryWrapper<Role> queryWrapper = roleQueryParam.build();
        queryWrapper.eq(StringUtils.isNotBlank(roleQueryParam.getName()), "name", roleQueryParam.getName());
        queryWrapper.eq(StringUtils.isNotBlank(roleQueryParam.getCode()), "code", roleQueryParam.getCode());
        return this.page(page, queryWrapper);
    }
}