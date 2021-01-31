package pers.tom.docwarehouse.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author tom
 * @description user 信息
 * @date 2021/1/30 21:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    /**userId*/
    private Long userId;

    /**username*/
    private String username;

    /**上次登录时间*/
    private String lastLoginTime;


}
