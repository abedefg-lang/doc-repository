package pers.tom.docwarehouse.model.supports.auditable;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import pers.tom.docwarehouse.security.SecurityInfo;
import pers.tom.docwarehouse.security.SecurityInfoHolder;

import java.util.Date;

/**
 * @author lijia
 * @description
 * @date 2021-01-29 14:30
 */
@Component
public class AuditableMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

        //设置创建人
        SecurityInfo securityInfo = SecurityInfoHolder.getSecurityInfo();
        if(metaObject.hasSetter("createdBy")){
            metaObject.setValue("createdBy", securityInfo == null ? "" : securityInfo.getIdentityInfo());
        }

        //设置创建人id
        if(metaObject.hasSetter("creatorId")){
            metaObject.setValue("creatorId", securityInfo == null ? -1L : securityInfo.getIdentity());
        }

        //设置创建时间
        if(metaObject.hasSetter("createTime")){
            metaObject.setValue("createTime", new Date());
        }


        //在新增的时候需要填充修改的属性
        this.updateFill(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        //设置修改人
        SecurityInfo securityInfo = SecurityInfoHolder.getSecurityInfo();
        if(metaObject.hasSetter("updatedBy")){
            metaObject.setValue("updatedBy", securityInfo == null ? "" : securityInfo.getIdentityInfo());
        }

        //设置修改人id
        if(metaObject.hasSetter("updaterId")){
            metaObject.setValue("updaterId", securityInfo == null ? -1L : securityInfo.getIdentity());
        }

        //设置修改时间
        if(metaObject.hasSetter("updateTime")){
            metaObject.setValue("updateTime", new Date());
        }

    }
}
