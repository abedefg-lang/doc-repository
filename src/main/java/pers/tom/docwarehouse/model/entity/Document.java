package pers.tom.docwarehouse.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pers.tom.docwarehouse.model.entity.base.AuditableEntity;

/**
 * @author lijia
 * @description 文档
 * @date 2021-02-01 11:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document extends AuditableEntity {

    @TableId(value = "document_id", type = IdType.AUTO)
    private Long documentId;

    @TableField("module_id")
    private Long moduleId;

    @TableField("title")
    private String title;

    @TableField("content")
    private String content;

    @TableField("overview")
    private String overview;
}
