package pers.tom.docwarehouse.model.supports.auditable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @author lijia
 * @description 可审计实体对象
 * @date 2021-01-29 13:19
 */
@Data
public abstract class AuditableEntity {

    /**创建人用户名*/
    @TableField(value = "created_by", fill = FieldFill.INSERT)
    private String createdBy;

    /**创建人id*/
    @TableField(value = "creator_id", fill = FieldFill.INSERT)
    private Long creatorId;

    /**创建时间*/
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**修改人用户名*/
    @TableField(value = "updated_by", fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;

    /**修改人id*/
    @TableField(value = "updater_id", fill = FieldFill.INSERT)
    private Long updaterId;

    /**修改时间*/
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
