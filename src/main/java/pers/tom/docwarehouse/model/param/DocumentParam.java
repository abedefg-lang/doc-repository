package pers.tom.docwarehouse.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pers.tom.docwarehouse.model.entity.Document;
import pers.tom.docwarehouse.model.supports.converter.InputData;

import javax.validation.constraints.NotBlank;

/**
 * @author lijia
 * @description
 * @date 2021-02-04 10:58
 */
@Data
@ApiModel
public class DocumentParam implements InputData<Document> {


    @ApiModelProperty("分类id")
    private Long categoryId;

    @NotBlank
    @ApiModelProperty("标题")
    private String title;

    @NotBlank
    @ApiModelProperty("文档内容")
    private String content;

    @NotBlank
    @ApiModelProperty("文档概述")
    private String contentOverview;

    @Override
    public Document converterTo() {
        Document document = new Document();
        document.setCategoryId(categoryId);
        document.setTitle(title);
        document.setContent(content);
        document.setContentOverview(contentOverview);
        return document;
    }
}
