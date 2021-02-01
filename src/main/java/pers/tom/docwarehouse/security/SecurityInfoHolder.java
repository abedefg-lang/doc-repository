package pers.tom.docwarehouse.security;

/**
 * @author tom
 * @description
 * @date 2021/1/30 21:59
 */
public class SecurityInfoHolder {

    /**存储user info*/
    private static final ThreadLocal<SecurityInfo> SECURITY_INFO_THREAD_LOCAL = new ThreadLocal<>();


    public static SecurityInfo getSecurityInfo(){
        return SECURITY_INFO_THREAD_LOCAL.get();
    }


    public static void setSecurityInfo(SecurityInfo info){
        SECURITY_INFO_THREAD_LOCAL.set(info);
    }

    public static void removeSecurityInfo(){
        SECURITY_INFO_THREAD_LOCAL.remove();
    }

}
