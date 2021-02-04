package pers.tom.docwarehouse.model.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.StringUtils;
import pers.tom.docwarehouse.model.entity.User;
import pers.tom.docwarehouse.model.supports.converter.QueryWrapperConverter;

/**
 * @author lijia
 * @description
 * @date 2021-02-04 13:13
 */
@Data
@ApiModel
public class UserQuery implements QueryWrapperConverter<User> {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("起始登录时间")
    private String startLoginTime;

    @ApiModelProperty("结束登录时间")
    private String endLoginTime;


    @Override
    public QueryWrapper<User> toQueryWrapper() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight(!StringUtils.isEmpty(username), "username", username)
                .ge(!StringUtils.isEmpty(startLoginTime), "last_login_time", startLoginTime)
                .le(!StringUtils.isEmpty(endLoginTime), "end_login_time", endLoginTime);
        return queryWrapper;
    }
}
