package com.github.geekcloud.system.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.geekcloud.system.admin.dao.PositionMapper;
import com.github.geekcloud.system.admin.entity.param.PositionQueryParam;
import com.github.geekcloud.system.admin.entity.po.Position;
import com.github.geekcloud.system.admin.service.IPositionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: PositionService
 * @author: jeffrey
 * @date: 2020年05月29日
 * @Description: TODO
 */
@Service
@Slf4j
public class PositionService extends ServiceImpl<PositionMapper, Position> implements IPositionService {

    @Override
    public boolean add(Position position) {
        return this.save(position);
    }

    @Override
    //@CacheInvalidate(name = "position::", key = "#id")
    public boolean delete(String id) {
        return this.removeById(id);
    }

    @Override
    //@CacheInvalidate(name = "position::", key = "#position.id")
    public boolean update(Position position) {
        return this.updateById(position);
    }

    @Override
    //@Cached(name = "position::", key = "#id", cacheType = CacheType.BOTH)
    public Position get(String id) {
        return this.getById(id);
    }

    @Override
    public List<Position> query(PositionQueryParam positionQueryParam) {
        QueryWrapper<Position> queryWrapper = positionQueryParam.build();
        queryWrapper.eq(StringUtils.isNotBlank(positionQueryParam.getName()), "name", positionQueryParam.getName());
        return this.list(queryWrapper);
    }
}

