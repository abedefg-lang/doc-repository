package pers.tom.docwarehouse.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lijia
 * @description 登录成功之后返回的user信息
 * @date 2021-02-01 14:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class AuthUser {

    @ApiModelProperty("user信息")
    private UserDto user;

    @ApiModelProperty("token")
    private String token;
}
