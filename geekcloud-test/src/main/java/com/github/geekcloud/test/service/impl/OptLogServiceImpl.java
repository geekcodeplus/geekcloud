package com.github.geekcloud.test.service.impl;

import com.github.geekcloud.framework.log.entity.OptLogDTO;
import com.github.geekcloud.test.service.OptLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName: OptLogServiceImpl
 * @author: jeffrey
 * @date: 2020年04月16日
 * @Description: TODO
 */
@Slf4j
@Service
public class OptLogServiceImpl implements OptLogService {
    @Override
    public boolean save(OptLogDTO entity) {
        log.info("OptLogServiceImpl 保存成功！！" + entity.toString());
        return true;
    }
}
