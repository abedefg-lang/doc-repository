package pers.tom.docrepository.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.tom.docrepository.model.entity.User;
import pers.tom.docrepository.repository.mapper.UserMapper;
import pers.tom.docrepository.service.UserService;

/**
 * @author lijia
 * @description user service impl
 * @date 2021-01-29 13:34
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
