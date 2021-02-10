package pers.tom.docwarehouse.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pers.tom.docwarehouse.model.entity.DocumentVersion;
import pers.tom.docwarehouse.model.supports.converter.OutputData;
import pers.tom.docwarehouse.utils.DateFormatUtils;

/**
 * @author tom
 * @description
 * @date 2021/2/9 12:50
 */
@Data
@ApiModel
public class DocumentVersionDto implements OutputData<DocumentVersionDto, DocumentVersion> {

    @ApiModelProperty("主键id")
    private Long documentVersionId;

    @ApiModelProperty("所属文档id")
    private Long documentId;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("内容概述")
    private String contentOverview;

    @ApiModelProperty("创建人")
    private String createdBy;

    @ApiModelProperty("创建人id")
    private Long creatorId;

    @ApiModelProperty("创建时间")
    private String createTime;

    @Override
    public DocumentVersionDto converterFrom(DocumentVersion documentVersion) {
        if(documentVersion != null){
            this.documentVersionId = documentVersion.getDocumentVersionId();
            this.documentId = documentVersion.getDocumentId();
            this.content = documentVersion.getContent();
            this.contentOverview = documentVersion.getContentOverview();
            this.createdBy = documentVersion.getCreatedBy();
            this.creatorId = documentVersion.getCreatorId();
            this.createTime = DateFormatUtils.format(DateFormatUtils.SECOND_LEVEL_PATTERN, documentVersion.getCreateTime());
        }
        return this;
    }
}
