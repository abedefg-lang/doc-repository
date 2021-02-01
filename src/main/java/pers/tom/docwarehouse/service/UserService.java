package pers.tom.docwarehouse.service;

import pers.tom.docwarehouse.model.dto.AuthUser;
import pers.tom.docwarehouse.model.dto.UserDto;
import pers.tom.docwarehouse.model.entity.User;
import pers.tom.docwarehouse.model.param.LoginParam;
import pers.tom.docwarehouse.service.supports.ConvertibleService;

/**
 * @author lijia
 * @description user service
 * @date 2021-01-29 13:34
 */
public interface UserService extends ConvertibleService<UserDto, User> {

    /**
     * 登录
     * @param loginParam 登录参数
     * @return 返回dto
     */
    AuthUser login(LoginParam loginParam);


}
