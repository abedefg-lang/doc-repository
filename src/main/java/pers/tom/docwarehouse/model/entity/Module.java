package pers.tom.docwarehouse.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pers.tom.docwarehouse.model.entity.base.AuditableEntity;

/**
 * @author tom
 * @description 模块
 * @date 2021/1/30 15:42
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("module")
public class Module extends AuditableEntity {

    @TableId(value = "module_id", type = IdType.AUTO)
    private Long moduleId;

    @TableField("name")
    private String name;

}
