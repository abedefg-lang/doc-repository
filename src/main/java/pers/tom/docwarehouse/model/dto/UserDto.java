package pers.tom.docwarehouse.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.tom.docwarehouse.model.entity.User;
import pers.tom.docwarehouse.model.supports.OutputConverter;
import pers.tom.docwarehouse.utils.SimpleDataFormatUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tom
 * @description
 * @date 2021/1/30 22:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class UserDto implements OutputConverter<User> {

    @ApiModelProperty("主键")
    private Long userId;

    @ApiModelProperty("username")
    private String username;

    @ApiModelProperty("上次登录时间")
    private String lastLoginTime;

    @Override
    public void converterFrom(User user) {
        if(user != null){
            this.userId = user.getUserId();
            this.username = user.getUsername();

            SimpleDateFormat format = SimpleDataFormatUtils.getFormat(SimpleDataFormatUtils.SECOND_LEVEL_PATTERN);
            this.lastLoginTime = format.format(new Date(user.getLastLoginTime()));
        }
    }
}
