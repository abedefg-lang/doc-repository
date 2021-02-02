package pers.tom.docwarehouse.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tom
 * @description
 * @date 2021/2/3 0:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class AuthUser {

    @ApiModelProperty("用户信息")
    private UserDto user;

    @ApiModelProperty("token")
    private String token;
}
