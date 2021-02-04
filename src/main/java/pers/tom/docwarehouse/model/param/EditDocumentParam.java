package pers.tom.docwarehouse.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lijia
 * @description 编辑文档参数对象
 * @date 2021-02-04 14:53
 */
@Data
@ApiModel("编辑文档参数对象")
public class EditDocumentParam {

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("内容概述")
    private String contentOverview;
}
