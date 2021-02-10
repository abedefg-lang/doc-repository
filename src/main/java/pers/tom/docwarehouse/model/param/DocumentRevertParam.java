package pers.tom.docwarehouse.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author tom
 * @description 文档回退参数
 * @date 2021/2/10 16:01
 */
@Data
@ApiModel
public class DocumentRevertParam {


    @ApiModelProperty(value = "需要回退的版本主键", required = true)
    private Long versionId;
}
