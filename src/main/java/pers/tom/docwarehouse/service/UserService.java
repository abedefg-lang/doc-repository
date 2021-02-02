package pers.tom.docwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.tom.docwarehouse.model.dto.AuthUser;
import pers.tom.docwarehouse.model.entity.User;
import pers.tom.docwarehouse.model.param.LoginParam;

/**
 * @author lijia
 * @description
 * @date 2021/2/3 0:13
 */
public interface UserService extends IService<User> {

    /**
     * 登录
     * @param loginParam 登录参数
     * @return 登录成功返回用户信息 token
     */
    AuthUser login(LoginParam loginParam);
}
