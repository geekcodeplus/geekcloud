package com.github.geekcloud.framework.boot.web.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    public static HttpSession getSession() {
        HttpSession session = request().getSession();
        return session;
    }
}
