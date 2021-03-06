package com.github.geekcloud.framework.log.entity;

import com.github.geekcloud.framework.core.base.enums.OptLogBizType;
import com.github.geekcloud.framework.core.base.enums.OptLogSaveType;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author： jeffrey
 * @date： 2020/4/12
 * @description： 实体类  系统日志
 * @modified By：
 * @version: 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
@Accessors(chain = true)
public class OptLogDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 操作IP
     */
    private String requestIp;

    private String tenantCode;

    /**
     * 日志链路追踪id日志标志
     */
    private String trace;

    /**
     * 日志类型
     */
    private String type;

    /**
     * 日志业务类型
     * @see OptLogBizType
     */
    private String bizType;

    /**
     * 日志操作类型
     * @see OptLogSaveType
     */
    private OptLogSaveType saveType;

    /**
     * 操作人
     */
    private String userName;

    /**
     * 操作描述
     */
    private String description;

    /**
     * 类路径
     */
    private String classPath;

    /**
     * 请求类型
     */
    private String actionMethod;

    /**
     * 请求地址
     */
    private String requestUri;

    /**
     * 请求类型
     * #HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}
     */
    private String httpMethod;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 返回值
     */
    private String result;

    /**
     * 异常详情信息
     */
    private String exDesc;

    /**
     * 异常描述
     */
    private String exDetail;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 完成时间
     */
    private LocalDateTime finishTime;

    /**
     * 消耗时间
     */
    private Long consumingTime;

    /**
     * 浏览器
     */
    private String ua;

    private Long createUser;


}
