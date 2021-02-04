package pers.tom.docwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.tom.docwarehouse.exception.AuthenticationException;
import pers.tom.docwarehouse.mapper.UserMapper;
import pers.tom.docwarehouse.model.dto.AuthUser;
import pers.tom.docwarehouse.model.dto.UserDto;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.entity.User;
import pers.tom.docwarehouse.model.param.LoginParam;
import pers.tom.docwarehouse.model.query.UserQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.security.SecurityInfo;
import pers.tom.docwarehouse.security.SecurityInfoHolder;
import pers.tom.docwarehouse.security.jwt.JwtTokenCodec;
import pers.tom.docwarehouse.service.OperationLogService;
import pers.tom.docwarehouse.service.UserService;
import pers.tom.docwarehouse.utils.CollectionUtils2;

import java.util.Date;
import java.util.List;

/**
 * @author tom
 * @description
 * @date 2021/2/3 0:16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    private final JwtTokenCodec tokenCodec;

    private final OperationLogService logService;

    public UserServiceImpl(JwtTokenCodec tokenCodec,
                           OperationLogService logService) {
        this.tokenCodec = tokenCodec;
        this.logService = logService;
    }

    @Override
    public AuthUser login(LoginParam loginParam) {

        User user = authentication(loginParam.getUsername(), loginParam.getPassword());

        //修改登录时间
        updateLastLoginTime(user);

        SecurityInfo securityInfo = new SecurityInfo(user.getUserId(), user.getUsername());
        SecurityInfoHolder.setSecurityInfo(securityInfo);

        //写入日志
        logService.saveLog(new OperationLog("登录系统"));

        //返回authUser
        return new AuthUser(new UserDto().converterFrom(user), tokenCodec.encode(securityInfo));
    }

    @Override
    public List<UserDto> listBy(UserQuery userQuery) {

        return CollectionUtils2.transform(baseMapper.selectList(userQuery.toQueryWrapper()), user -> new UserDto().converterFrom(user));

    }

    @Override
    public PageResult<UserDto> pageBy(UserQuery userQuery, PageParam pageParam) {

        Page<User> page = new Page<>(pageParam.getPage(), pageParam.getPageSize(), pageParam.isSearchTotal());
        baseMapper.selectPage(page, userQuery.toQueryWrapper());
        return PageResult.fromIPage(page, user -> new UserDto().converterFrom(user));
    }

    /**
     * 身份验证
     * @param username username
     * @param password password
     * @return 认证成功返回user
     */
    private User authentication(String username, String password){
        User user = baseMapper.selectByUsername(username);
        if(user == null || !user.getPassword().equals(password)){
            throw new AuthenticationException("用户名或密码错误");
        }
        return user;
    }

    /**
     * 修改登录时间
     * @param user user
     */
    private void updateLastLoginTime(User user){

        //TODO 改为异步修改
        user.setLastLoginTime(new Date());
        baseMapper.updateById(user);
    }

}
