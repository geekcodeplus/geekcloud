package com.github.geekcloud.framework.boot.base.vo;

import com.github.geekcloud.framework.boot.base.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: BaseVo
 * @author: jeffrey
 * @date: 2020年05月25日
 * @Description: TODO
 */
@Data
@NoArgsConstructor
public class BaseVo<T extends BasePo> implements Serializable {
    private String id;
}
