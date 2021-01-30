package pers.tom.docwarehouse.controller.supports;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pers.tom.docwarehouse.annotation.ApiAuthentication;
import pers.tom.docwarehouse.exception.AuthenticationException;
import pers.tom.docwarehouse.security.SecurityConstant;
import pers.tom.docwarehouse.security.UserInfo;
import pers.tom.docwarehouse.security.UserInfoHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author tom
 * @description 实现api认证的拦截器
 * @date 2021/1/30 22:11
 */
@Component
public class ApiAuthenticationInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if(handler instanceof HandlerMethod){
            //判断方法上面或者类上面是否标识了认证注解
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if(handlerMethod.hasMethodAnnotation(ApiAuthentication.class)
                    || handlerMethod.getBeanType().isAnnotationPresent(ApiAuthentication.class)){

                //判断session中记录了UserInfo
                HttpSession session = request.getSession();
                UserInfo userInfo = (UserInfo) session.getAttribute(SecurityConstant.USER_INFO_SESSION_KEY);
                if(userInfo == null){
                    throw new AuthenticationException("请重新登录");
                }

                //刷新session活跃时间
                UserInfoHolder.setUserInfo(userInfo);
                session.setMaxInactiveInterval(SecurityConstant.USER_LOGIN_EXPIRATION_TIME);
            }
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

        //请求执行完成后删除holder中的数据
        UserInfoHolder.removeUserInfo();
    }

}
