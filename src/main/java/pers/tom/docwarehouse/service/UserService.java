package pers.tom.docwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.tom.docwarehouse.model.dto.AuthUser;
import pers.tom.docwarehouse.model.dto.UserDto;
import pers.tom.docwarehouse.model.entity.User;
import pers.tom.docwarehouse.model.param.LoginParam;
import pers.tom.docwarehouse.model.query.UserQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;

import java.util.List;

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

    /**
     * 条件查询用户信息
     * @param userQuery 查询条件
     * @return 返回数据
     */
    List<UserDto> listBy(UserQuery userQuery);

    /**
     * 分页查询用户信息
     * @param userQuery 查询条件
     * @param pageParam 分页参数
     * @return 返回分页结果
     */
    PageResult<UserDto> pageBy(UserQuery userQuery, PageParam pageParam);
}
