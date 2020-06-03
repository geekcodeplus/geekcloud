package com.github.geekcloud.gateway.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.geekcloud.gateway.admin.entity.po.GatewayRoute;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: GatewayRouteMapper
 * @author: jeffrey
 * @date: 2020年05月25日
 * @Description: TODO
 */
@Mapper
@Repository
public interface GatewayRouteMapper extends BaseMapper<GatewayRoute> {
}
