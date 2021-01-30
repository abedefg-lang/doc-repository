package pers.tom.docwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.tom.docwarehouse.exception.ServiceException;
import pers.tom.docwarehouse.mapper.UserMapper;
import pers.tom.docwarehouse.model.dto.UserDto;
import pers.tom.docwarehouse.model.entity.User;
import pers.tom.docwarehouse.model.param.LoginParam;
import pers.tom.docwarehouse.service.UserService;

/**
 * @author lijia
 * @description user service impl
 * @date 2021-01-29 13:34
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User login(LoginParam loginParam) {

        //先通过用户名查询出数据
        User user = baseMapper.selectByUsername(loginParam.getUsername());
        if(user == null || !loginParam.getPassword().equals(user.getPassword())){
            throw new ServiceException("账号或用户名错误");
        }

        //修改登录时间
        user.setLastLoginTime(System.currentTimeMillis());

        return user;
    }

    @Override
    public UserDto converterToDto(User user) {

        if(user != null){
            UserDto userDto = new UserDto();
            userDto.converterFrom(user);
            return userDto;
        }
        return null;
    }
}
