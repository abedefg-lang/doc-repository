package pers.tom.docwarehouse.model.supports;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author tom
 * @description 分页查询结果
 * @date 2021/1/31 0:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class PageResult<T> {

    @ApiModelProperty("总数")
    private Long total;

    @ApiModelProperty("查询结果")
    private List<T> list;

}
