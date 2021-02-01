package pers.tom.docwarehouse.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.tom.docwarehouse.model.dto.base.AuditableDto;
import pers.tom.docwarehouse.model.entity.Document;

/**
 * @author lijia
 * @description
 * @date 2021-02-01 11:11
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class DocumentDto extends AuditableDto<Document> {

    @ApiModelProperty("主键id")
    private Long documentId;

    @ApiModelProperty("模块id")
    private Long moduleId;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("内容概述")
    private String overview;

    @Override
    protected void doConverter(Document document) {
        this.documentId = document.getDocumentId();
        this.moduleId = document.getModuleId();
        this.title = document.getTitle();
        this.content = document.getContent();
        this.overview = document.getOverview();
    }
}
