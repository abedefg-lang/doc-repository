package pers.tom.docwarehouse.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author tom
 * @description 文档版本
 * @date 2021/2/9 12:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("document_version")
public class DocumentVersion {

    @TableId(value = "document_version_id", type = IdType.AUTO)
    private Long documentVersionId;

    @TableField("document_id")
    private Long documentId;

    @TableField("content")
    private String content;

    @TableField("content_overview")
    private String contentOverview;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createdBy;

    @TableField(value = "creator_id", fill = FieldFill.INSERT)
    private Long creatorId;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;


    public DocumentVersion(Long documentId, String content, String contentOverview){
        this.documentId = documentId;
        this.content = content;
        this.contentOverview = contentOverview;
    }
}
