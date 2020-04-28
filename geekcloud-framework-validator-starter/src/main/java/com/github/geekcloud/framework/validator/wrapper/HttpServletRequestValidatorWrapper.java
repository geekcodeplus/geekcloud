package com.github.geekcloud.framework.validator.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @ClassName: HttpServletRequestValidatorWrapper
 * @author: jeffrey
 * @date: 2020年04月28日
 * @Description: 验证请求包装器
 */
public class HttpServletRequestValidatorWrapper extends HttpServletRequestWrapper {

    private String formPath = null;

    public HttpServletRequestValidatorWrapper(HttpServletRequest request, String uri) {
        super(request);
        this.formPath = uri;
    }

    @Override
    public String getRequestURI() {
        return this.formPath;
    }

    @Override
    public String getServletPath() {
        return this.formPath;
    }
}