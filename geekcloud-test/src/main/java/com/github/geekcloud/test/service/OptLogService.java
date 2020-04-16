package com.github.geekcloud.test.service;

import com.github.geekcloud.framework.log.entity.OptLogDTO;

/**
 * @ClassName: OptLogService
 * @author: jeffrey
 * @date: 2020年04月16日
 * @Description: TODO
 */
public interface OptLogService {

    /**
     * 保存日志
     *
     * @param entity
     * @return
     */
    boolean save(OptLogDTO entity);
}
