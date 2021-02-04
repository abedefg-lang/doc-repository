package pers.tom.docwarehouse.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.tom.docwarehouse.model.entity.Document;
import pers.tom.docwarehouse.model.supports.auditable.AuditableDto;

/**
 * @author lijia
 * @description
 * @date 2021-02-04 11:00
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class DocumentDto extends AuditableDto<DocumentDto, Document> {

    @ApiModelProperty("主键")
    private Long documentId;

    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("文档标题")
    private String title;

    @ApiModelProperty("文档内容")
    private String content;

    @ApiModelProperty("文档概述")
    private String contentOverview;

    @Override
    protected void doConverter(Document document) {
        this.documentId = document.getDocumentId();
        this.categoryName = "";
        this.categoryId = document.getCategoryId();
        this.title = document.getTitle();
        this.content = document.getContent();
        this.contentOverview = document.getContentOverview();
    }
}
