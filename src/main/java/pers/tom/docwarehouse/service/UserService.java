package pers.tom.docwarehouse.service;

import pers.tom.docwarehouse.model.dto.UserDto;
import pers.tom.docwarehouse.model.param.LoginParam;

/**
 * @author lijia
 * @description user service
 * @date 2021-01-29 13:34
 */
public interface UserService{

    /**
     * 登录
     * @param loginParam 登录参数
     * @return 返回dto
     */
    UserDto login(LoginParam loginParam);

    /**
     * 登出
     */
    void logout();


}
