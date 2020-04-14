package com.github.geekcloud.framework.log.event;

import com.github.geekcloud.framework.log.entity.OptLogDTO;

import java.util.EventObject;

/**
 * @author： jeffrey
 * @date： 2020/4/12
 * @description： 系统日志事件
 * @modified By：
 * @version: 1.0.0
 */
public class SysLogEvent extends EventObject {//ApplicationEvent {

    public SysLogEvent(OptLogDTO source) {
        super(source);
    }
}
