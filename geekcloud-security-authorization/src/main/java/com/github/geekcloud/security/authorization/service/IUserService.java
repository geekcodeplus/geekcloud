package com.github.geekcloud.security.authorization.service;

import com.github.geekcloud.security.authorization.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName: IUserService
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@Service
public interface IUserService {

    /**
     * 根据用户唯一标识获取用户信息
     *
     * @param uniqueId
     * @return
     */
    @Cacheable(value = "#id")
    User getByUniqueId(String uniqueId);
}
