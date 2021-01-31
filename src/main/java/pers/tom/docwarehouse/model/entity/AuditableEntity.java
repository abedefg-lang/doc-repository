package pers.tom.docwarehouse.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import pers.tom.docwarehouse.security.UserInfo;
import pers.tom.docwarehouse.security.UserInfoHolder;

/**
 * @author lijia
 * @description 可审计实体对象
 * @date 2021-01-29 13:19
 */
@Data
public abstract class AuditableEntity {

    /**创建人用户名*/
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    /**创建时间*/
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    /**修改人用户名*/
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**修改时间*/
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

    /**
     * 判断操作这条数据的人是否是这条数据的创建人
     * 通过获取userInfo中的username与createBy比较
     * @return  返回是否是创建人
     */
    private boolean isCreator(){
        UserInfo userInfo = UserInfoHolder.getUserInfo();
        return userInfo != null && userInfo.getUsername().equals(createBy);
    }
}
