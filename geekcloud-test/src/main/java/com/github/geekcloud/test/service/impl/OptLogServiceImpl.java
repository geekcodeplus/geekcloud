package com.github.geekcloud.test.service.impl;

import com.github.geekcloud.framework.cache.repository.CacheRepository;
import com.github.geekcloud.framework.log.entity.OptLogDTO;
import com.github.geekcloud.test.service.OptLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: OptLogServiceImpl
 * @author: jeffrey
 * @date: 2020年04月16日
 * @Description: TODO
 */
@Slf4j
@Service
public class OptLogServiceImpl implements OptLogService {

    @Resource
    private CacheRepository cacheRepository;

    @Override
    public boolean save(OptLogDTO entity) {
        log.info("OptLogServiceImpl 保存成功！！" + entity.toString());
        return true;
    }

    @Override
    public String getCache(String key) {
        return cacheRepository.get(key);
    }
}
