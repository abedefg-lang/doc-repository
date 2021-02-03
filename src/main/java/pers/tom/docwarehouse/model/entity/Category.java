package pers.tom.docwarehouse.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pers.tom.docwarehouse.model.supports.auditable.AuditableEntity;

/**
 * @author tom
 * @description
 * @date 2021/2/3 22:50
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("category")
public class Category extends AuditableEntity {

    @TableId(value = "category_id", type = IdType.AUTO)
    private Long  categoryId;

    @TableField("name")
    private String name;
}
