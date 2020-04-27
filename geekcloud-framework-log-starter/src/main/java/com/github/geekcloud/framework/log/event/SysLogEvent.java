package com.github.geekcloud.framework.log.event;

import com.github.geekcloud.framework.log.entity.OptLogDTO;
import org.springframework.context.ApplicationEvent;

/**
 * @author： jeffrey
 * @date： 2020/4/12
 * @description： 系统日志事件
 * @modified By：  EventObject {//
 * @version: 1.0.0
 */
public class SysLogEvent extends ApplicationEvent {

    public SysLogEvent(OptLogDTO source) {
        super(source);
    }
}
