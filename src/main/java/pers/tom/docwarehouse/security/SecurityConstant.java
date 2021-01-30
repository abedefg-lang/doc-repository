package pers.tom.docwarehouse.security;

/**
 * @author tom
 * @description 安全相关的常量
 * @date 2021/1/30 22:09
 */
public class SecurityConstant {

    /**从HttpSession中获取userInfo的keyName*/
    public static final String USER_INFO_SESSION_KEY = "userInfo";

    /**用户登录有效时间 超过这个时间需要重写登录 时间是三天 单位是秒*/
    public static final Integer USER_LOGIN_EXPIRATION_TIME = 3*24*60*60;
}
