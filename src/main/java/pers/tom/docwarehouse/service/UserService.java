package pers.tom.docwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.util.CollectionUtils;
import pers.tom.docwarehouse.model.dto.UserDto;
import pers.tom.docwarehouse.model.entity.User;
import pers.tom.docwarehouse.model.param.LoginParam;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lijia
 * @description user service
 * @date 2021-01-29 13:34
 */
public interface UserService extends IService<User> {

    /**
     * 登录
     * @param loginParam 登录参数
     * @return 返回dto
     */
    User login(LoginParam loginParam);


    UserDto converterToDto(User user);


    default List<UserDto> converterToDtoList(List<User> users){
        if(CollectionUtils.isEmpty(users)){
            return Collections.emptyList();
        }

        return users.stream().map(this::converterToDto).collect(Collectors.toList());
    }
}
