package com.github.geekcloud.framework.boot.base.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.github.geekcloud.framework.boot.base.po.BasePo;
import com.github.geekcloud.framework.core.utils.UserContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.function.Supplier;

/**
 * @ClassName: PoMetaObjectHandler
 * @author: jeffrey
 * @date: 2020年05月25日
 * @Description: TODO
 */
@Slf4j
public class PoMetaObjectHandler implements MetaObjectHandler {
    /**
     * 获取当前交易的用户，为空返回默认system
     *
     * @return
     */
    private String getCurrentUsername() {
        return StringUtils.defaultIfBlank(UserContextHolder.getInstance().getUsername(), BasePo.DEFAULT_USERNAME);
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setInsertFieldValByName("createdBy", getCurrentUsername(), metaObject);
        this.setInsertFieldValByName("createdTime", Date.from(ZonedDateTime.now().toInstant()), metaObject);
        this.updateFill(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //this.setUpdateFieldValByName("updatedBy", getCurrentUsername(), metaObject);
        //this.setUpdateFieldValByName("updatedTime", Date.from(ZonedDateTime.now().toInstant()), metaObject);
        this.setFieldValByName("updatedBy", getCurrentUsername(), metaObject);
        this.setFieldValByName("updatedTime", Date.from(ZonedDateTime.now().toInstant()), metaObject);
    }

//    private final String CREATED_BY = "createdBy";
//    private final String UPDATED_BY = "updatedBy";
//    private final String CREATED_DATE = "createdTime";
//    private final String UPDATED_DATE = "updatedTime";
//
//
//    @Override
//    public void insertFill(MetaObject metaObject) {
//        String operator = "bokai";
//        fillValue(metaObject, CREATED_BY, () -> operator);
//        fillValue(metaObject, UPDATED_BY, () -> operator);
//        fillValue(metaObject, CREATED_DATE, () -> getDateValue(metaObject.getSetterType(CREATED_DATE)));
//        fillValue(metaObject, UPDATED_DATE, () -> getDateValue(metaObject.getSetterType(UPDATED_DATE)));
//    }
//
//    @Override
//    public void updateFill(MetaObject metaObject) {
//        String operator = "bokai";
//        fillValue(metaObject, "et." + UPDATED_BY, () -> operator);
//        fillValue(metaObject, "et." + UPDATED_DATE, () -> getDateValue(metaObject.getSetterType("et." + UPDATED_DATE)));
//    }
//
//    private void fillValue(MetaObject metaObject, String fieldName, Supplier<Object> valueSupplier) {
//        if (!metaObject.hasGetter(fieldName)) {
//            return;
//        }
//        Object sidObj = metaObject.getValue(fieldName);
//        if (sidObj == null && metaObject.hasSetter(fieldName) && valueSupplier != null) {
//            setFieldValByName(fieldName, valueSupplier.get(), metaObject);
//        }
//    }
//
//    private Object getDateValue(Class<?> setterType) {
//        if (Date.class.equals(setterType)) {
//            return new Date();
//        } else if (LocalDateTime.class.equals(setterType)) {
//            return LocalDateTime.now();
//        }
//        return null;
//    }
}