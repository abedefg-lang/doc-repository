package pers.tom.docwarehouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.tom.docwarehouse.model.entity.User;

/**
 * @author lijia
 * @description user mapper
 * @date 2021-01-29 13:33
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过用户名查询用户
     * @param username username
     * @return 返回实体对象
     */
    User selectByUsername(@Param("username") String username);

}
