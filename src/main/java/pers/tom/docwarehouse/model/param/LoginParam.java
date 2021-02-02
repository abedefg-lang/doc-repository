package pers.tom.docwarehouse.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author tom
 * @description 登录参数对象
 * @date 2021/2/2 23:57
 */
@Data
@ApiModel
public class LoginParam {

    @NotBlank
    @ApiModelProperty("用户名")
    private String username;

    @NotBlank
    @ApiModelProperty("密码")
    private String password;
}
