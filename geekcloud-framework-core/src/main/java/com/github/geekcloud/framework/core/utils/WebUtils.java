package com.github.geekcloud.framework.core.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @ClassName: WebUtils
 * @author: jeffrey
 * @date: 2020年04月26日
 * @Description: TODO
 */
public class WebUtils {
    public static HttpServletRequest request() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }
}
