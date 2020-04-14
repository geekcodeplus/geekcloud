package com.github.geekcloud.framework.core.function;

/**
 * @ClassName: CheckedFunction
 * @Description: TODO
 * @author: jeffrey
 * @date: 2020年04月08日
 */

@FunctionalInterface
public interface CheckedFunction<T, R> {
    /**
     * 执行
     *
     * @param t 入参
     * @return R 出参
     * @throws Exception
     */
    R apply(T t) throws Exception;
}
