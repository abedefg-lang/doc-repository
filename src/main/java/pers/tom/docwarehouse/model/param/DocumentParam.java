package pers.tom.docwarehouse.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pers.tom.docwarehouse.model.supports.InputData;
import pers.tom.docwarehouse.model.entity.Document;

/**
 * @author lijia
 * @description
 * @date 2021-02-01 11:13
 */
@Data
@ApiModel
public class DocumentParam implements InputData<Document> {

    @ApiModelProperty("模块id")
    private Long moduleId;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("概述")
    private String overview;

    @Override
    public Document converterTo() {
        return null;
    }
}
