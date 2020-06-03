package com.github.geekcloud.system.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.geekcloud.system.admin.entity.param.RoleQueryParam;
import com.github.geekcloud.system.admin.entity.po.Role;

import java.util.List;

/**
 * @ClassName: IRoleService
 * @author: jeffrey
 * @date: 2020年05月29日
 * @Description: TODO
 */
public interface IRoleService {
    /**
     * 获取角色
     *
     * @param id
     * @return
     */
    Role get(String id);

    /**
     * 获取所有角色
     *
     * @return
     */
    List<Role> getAll();

    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    boolean add(Role role);

    /**
     * 查询角色
     *
     * @return
     */
    IPage<Role> query(Page page, RoleQueryParam roleQueryParam);

    /**
     * 根据用户id查询用户拥有的角色
     *
     * @return
     */
    List<Role> query(String userId);

    /**
     * 更新角色信息
     *
     * @param role
     */
    boolean update(Role role);

    /**
     * 根据id删除角色
     *
     * @param id
     */
    boolean delete(String id);
}
