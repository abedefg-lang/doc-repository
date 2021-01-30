package pers.tom.docwarehouse.security;

/**
 * @author tom
 * @description
 * @date 2021/1/30 21:59
 */
public class UserInfoHolder {

    /**存储user info*/
    private static final ThreadLocal<UserInfo> USER_INFO_THREAD_LOCAL = new ThreadLocal<>();


    public static UserInfo getUserInfo(){
        return USER_INFO_THREAD_LOCAL.get();
    }


    public static void setUserInfo(UserInfo info){
        USER_INFO_THREAD_LOCAL.set(info);
    }

    public static void removeUserInfo(){
        USER_INFO_THREAD_LOCAL.remove();
    }

}
