package com.github.geekcloud.system.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.geekcloud.system.admin.entity.po.RoleResource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleResourceMapper extends BaseMapper<RoleResource> {
}