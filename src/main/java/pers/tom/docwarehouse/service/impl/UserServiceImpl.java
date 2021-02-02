package pers.tom.docwarehouse.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import pers.tom.docwarehouse.config.properties.JwtConfiguration;
import pers.tom.docwarehouse.exception.AuthenticationException;
import pers.tom.docwarehouse.listener.OperationLogEvent;
import pers.tom.docwarehouse.mapper.UserMapper;
import pers.tom.docwarehouse.model.dto.AuthUser;
import pers.tom.docwarehouse.model.dto.UserDto;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.entity.User;
import pers.tom.docwarehouse.model.param.LoginParam;
import pers.tom.docwarehouse.security.SecurityInfo;
import pers.tom.docwarehouse.security.SecurityInfoHolder;
import pers.tom.docwarehouse.service.UserService;

import java.util.Date;

/**
 * @author tom
 * @description
 * @date 2021/2/3 0:16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    private final JwtConfiguration jwtConfiguration;

    private final ApplicationEventPublisher eventPublisher;

    public UserServiceImpl(JwtConfiguration jwtConfiguration,
                           ApplicationEventPublisher eventPublisher) {
        this.jwtConfiguration = jwtConfiguration;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public AuthUser login(LoginParam loginParam) {

        User user = baseMapper.selectByUsername(loginParam.getUsername());
        if(user == null || !loginParam.getPassword().equals(user.getPassword())){
            throw new AuthenticationException("用户名或密码错误");
        }

        //修改登录时间
        updateLastLoginTime(user);

        SecurityInfoHolder.setSecurityInfo(new SecurityInfo(user.getUserId(), user.getUsername()));

        //发布登录日志
        eventPublisher.publishEvent(new OperationLogEvent(new OperationLog("登录系统")));

        //返回authUser
        return new AuthUser(new UserDto().converterFrom(user), buildToken(user));
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

    /**
     * 构建token
     * @param user user
     * @return 返回token
     */
    private String buildToken(User user){

        return JWT.create()
                .withClaim(SecurityInfo.IDENTITY_NAME, user.getUserId())
                .withClaim(SecurityInfo.IDENTITY_INFO_NAME, user.getUsername())
                .withExpiresAt(jwtConfiguration.getExpireDate())
                .sign(Algorithm.HMAC256(jwtConfiguration.getSecretKey()));
    }
}
