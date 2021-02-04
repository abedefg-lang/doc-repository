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
 * @date 2021/2/3 23:53
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("document")
public class Document extends AuditableEntity {

    @TableId(value = "document_id", type = IdType.AUTO)
    private Long documentId;

    @TableField("category_id")
    private Long categoryId;

    @TableField("title")
    private String title;

    @TableField("content")
    private String content;

    @TableField("content_overview")
    private String contentOverview;
}
