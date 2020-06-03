package com.github.geekcloud.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.geekcloud.system.admin.entity.param.GroupQueryParam;
import com.github.geekcloud.system.admin.entity.po.Group;

import java.util.List;

/**
 * @ClassName: IGroupService
 * @author: jeffrey
 * @date: 2020年05月29日
 * @Description: TODO
 */
public interface IGroupService extends IService<Group> {
    /**
     * 获取用户组
     *
     * @param id
     * @return
     */
    Group get(String id);

    /**
     * 新增用户组
     *
     * @param group
     * @return true为新增成功
     */
    boolean add(Group group);

    /**
     * 查询用户组
     *
     * @return
     */
    List<Group> query(GroupQueryParam groupQueryParam);

    /**
     * 根据父id查询用户组
     *
     * @return
     */
    List<Group> queryByParentId(String id);

    /**
     * 更新用户组信息
     *
     * @param group
     */
    boolean update(Group group);

    /**
     * 根据id删除用户组
     *
     * @param id
     */
    boolean delete(String id);
}
