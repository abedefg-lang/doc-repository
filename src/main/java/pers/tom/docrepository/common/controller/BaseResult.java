package pers.tom.docrepository.common.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lijia
 * @description 基本返回对象
 * @date 2021-01-29 13:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class BaseResult<T> {

    @ApiModelProperty("状态码")
    private int code;

    @ApiModelProperty("返回消息")
    private String message;

    @ApiModelProperty("返回数据")
    private T data;
}
