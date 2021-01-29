package pers.tom.docrepository.common.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

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
}
