package pers.tom.docwarehouse.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.tom.docwarehouse.model.entity.User;
import pers.tom.docwarehouse.model.supports.converter.OutputData;
import pers.tom.docwarehouse.utils.DateFormatUtils;

/**
 * @author tom
 * @description
 * @date 2021/2/3 0:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class UserDto implements OutputData<UserDto, User> {

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("上一次登录时间")
    private String lastLoginTime;

    @Override
    public UserDto converterFrom(User user) {
        if(user != null){
            this.userId = user.getUserId();
            this.username = user.getUsername();
            this.lastLoginTime = DateFormatUtils.format(DateFormatUtils.SECOND_LEVEL_PATTERN, user.getLastLoginTime());
        }

        return this;
    }
}
