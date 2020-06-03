package com.github.geekcloud.system.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.geekcloud.system.admin.dao.GroupMapper;
import com.github.geekcloud.system.admin.entity.param.GroupQueryParam;
import com.github.geekcloud.system.admin.entity.po.Group;
import com.github.geekcloud.system.admin.service.IGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: GroupService
 * @author: jeffrey
 * @date: 2020年05月29日
 * @Description: TODO
 */
@Service
@Slf4j
public class GroupService extends ServiceImpl<GroupMapper, Group> implements IGroupService {

    @Override
    public boolean add(Group group) {
        return this.save(group);
    }

    @Override
    //@CacheInvalidate(name = "group::", key = "#id")
    public boolean delete(String id) {
        return this.removeById(id);
    }

    @Override
    //@CacheInvalidate(name = "group::", key = "#group.id")
    public boolean update(Group group) {
        return this.updateById(group);
    }

    @Override
    //@Cached(name = "group::", key = "#id", cacheType = CacheType.BOTH)
    public Group get(String id) {
        return this.getById(id);
    }

    @Override
    public List<Group> query(GroupQueryParam groupQueryParam) {
        QueryWrapper<Group> queryWrapper = groupQueryParam.build();
        queryWrapper.eq("name", groupQueryParam.getName());
        return this.list(queryWrapper);
    }

    @Override
    public List<Group> queryByParentId(String id) {
        return this.list(new QueryWrapper<Group>().eq("parent_id", id));
    }
}

