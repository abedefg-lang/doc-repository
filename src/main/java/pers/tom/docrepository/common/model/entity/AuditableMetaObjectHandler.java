package pers.tom.docrepository.common.model.entity;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author lijia
 * @description
 * @date 2021-01-29 14:30
 */
@Component
public class AuditableMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

        //设置创建时间
        if(metaObject.hasSetter("createTime")){
            metaObject.setValue("createTime", System.currentTimeMillis());
        }
        //设置创建人
        if(metaObject.hasSetter("createBy")){
            metaObject.setValue("createBy", "TOM");
        }

        //在新增的时候需要填充修改的属性
        this.updateFill(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //设置修改时间
        if(metaObject.hasSetter("updateTime")){
            metaObject.setValue("updateTime", System.currentTimeMillis());
        }
        //设置修改人
        if(metaObject.hasSetter("updateBy")){
            metaObject.setValue("updateBy", "TOM");
        }
    }
}
