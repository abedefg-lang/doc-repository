package pers.tom.docwarehouse.model.supports;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

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
    private Integer status;

    @ApiModelProperty("返回消息")
    private String message;

    @ApiModelProperty("返回数据")
    private T data;


    public static <T>BaseResult<T> ok(String message){
        return new BaseResult<>(HttpStatus.OK.value(), message, null);
    }

    public static <T>BaseResult<T> ok(String message, T data){
        return new BaseResult<>(HttpStatus.OK.value(), message, data);
    }

    public static <T>BaseResult<T> ok(T data){
        return new BaseResult<>(HttpStatus.OK.value(), "ok", data);
    }


}
