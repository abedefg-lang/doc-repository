package pers.tom.docwarehouse.model.param.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author tom
 * @description 分页查询参数
 * @date 2021/1/31 0:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class PageParam {

    @Min(0)
    @ApiModelProperty("分页页码")
    private Integer page;

    @Min(0)
    @ApiModelProperty("每一页的大小")
    private Integer pageSize;

    @ApiModelProperty("是否查询总数 默认查询")
    private Boolean searchTotal = true;
}
