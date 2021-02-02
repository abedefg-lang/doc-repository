package pers.tom.docwarehouse.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import pers.tom.docwarehouse.config.properties.JwtConfiguration;
import pers.tom.docwarehouse.exception.ServiceException;
import pers.tom.docwarehouse.listener.OperationLogEvent;
import pers.tom.docwarehouse.mapper.UserMapper;
import pers.tom.docwarehouse.model.dto.UserDto;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.entity.User;
import pers.tom.docwarehouse.model.param.LoginParam;
import pers.tom.docwarehouse.model.dto.AuthUser;
import pers.tom.docwarehouse.security.SecurityInfo;
import pers.tom.docwarehouse.security.SecurityInfoHolder;
import pers.tom.docwarehouse.service.OperationLogService;
import pers.tom.docwarehouse.service.UserService;

import java.util.Date;


/**
 * @author lijia
 * @description user service impl
 * @date 2021-01-29 13:34
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    private final ApplicationEventPublisher eventPublisher;

    private final JwtConfiguration jwtConfiguration;

    public UserServiceImpl(ApplicationEventPublisher eventPublisher,
                           JwtConfiguration jwtConfiguration) {
        this.eventPublisher = eventPublisher;
        this.jwtConfiguration = jwtConfiguration;
    }


    @Override
    public AuthUser login(LoginParam loginParam) {

        //先通过用户名查询出数据
        User user = baseMapper.selectByUsername(loginParam.getUsername());
        if(user == null || !loginParam.getPassword().equals(user.getPassword())){
            throw new ServiceException("账号或用户名错误");
        }

        //修改登录时间
        user.setLastLoginTime(new Date());
        baseMapper.updateById(user);

        //记录操作日志
        SecurityInfoHolder.setSecurityInfo(new SecurityInfo(user.getUserId(), user.getUsername()));
        eventPublisher.publishEvent(new OperationLogEvent(new OperationLog("登录系统")));

        //创建token
        String token = JWT.create()
                .withClaim("userId", user.getUserId())
                .withExpiresAt(jwtConfiguration.getExpireDate())
                .sign(Algorithm.HMAC256(jwtConfiguration.getSecretKey()));

        return new AuthUser(convertTo(user), token);
    }


    @Override
    public UserDto convertTo(User user) {
        if(user != null){
            UserDto userDto = new UserDto();
            userDto.converterFrom(user);
            return userDto;
        }
        return null;
    }
}
