package com.github.geekcloud.system.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.geekcloud.system.admin.entity.po.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
}