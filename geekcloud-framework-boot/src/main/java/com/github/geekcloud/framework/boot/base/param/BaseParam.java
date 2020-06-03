package com.github.geekcloud.framework.boot.base.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.geekcloud.framework.boot.base.po.BasePo;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: BaseParam
 * @author: jeffrey
 * @date: 2020年05月25日
 * @Description: TODO
 */
@Data
public class BaseParam<T extends BasePo> {
    private Date createdTimeStart;
    private Date createdTimeEnd;

    public QueryWrapper<T> build() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge(null != this.createdTimeStart, "created_time", this.createdTimeStart)
                .le(null != this.createdTimeEnd, "created_time", this.createdTimeEnd);
        return queryWrapper;
    }
}