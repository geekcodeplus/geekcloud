package com.github.geekcloud.security.authentication.service;

import com.github.geekcloud.security.authentication.entity.po.Resource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: IResourceService
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@Service
public interface IResourceService {

    /**
     * 动态新增更新权限
     *
     * @param resource
     */
    void saveResource(Resource resource);

    /**
     * 动态删除权限
     *
     * @param resource
     */
    void removeResource(Resource resource);

    /**
     * 加载权限资源数据
     */
    Map<RequestMatcher, ConfigAttribute> loadResource();

    /**
     * 根据url和method查询到对应的权限信息
     *
     * @param authRequest
     * @return
     */
    ConfigAttribute findConfigAttributesByUrl(HttpServletRequest authRequest);

    /**
     * 根据用户名查询 该用户所拥有的角色对应的资源信息
     *
     * @param username
     * @return
     */
    Set<Resource> queryByUsername(String username);
}
