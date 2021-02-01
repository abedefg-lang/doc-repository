package pers.tom.docwarehouse.controller.handler;

import com.auth0.jwt.JWT;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pers.tom.docwarehouse.annotation.ApiAuthentication;
import pers.tom.docwarehouse.config.properties.JwtConfiguration;
import pers.tom.docwarehouse.exception.AuthenticationException;
import pers.tom.docwarehouse.security.SecurityInfo;
import pers.tom.docwarehouse.security.SecurityInfoHolder;
import pers.tom.docwarehouse.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lijia
 * @description 接口认证拦截器
 * @date 2021-02-01 14:04
 */
@Component
public class ApiAuthenticationInterceptor implements HandlerInterceptor {

    public static final String AUTHENTICATION_HEADER_NAME = "Authorization";

    private final UserService userService;

    private final JwtConfiguration jwtConfiguration;

    public ApiAuthenticationInterceptor(UserService userService,
                                        JwtConfiguration jwtConfiguration){
        this.userService = userService;
        this.jwtConfiguration = jwtConfiguration;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(this.authenticationRequired(request, handler)){
            SecurityInfo securityInfo = this.authentication(request);
            if(securityInfo == null){
                throw new AuthenticationException("请重新登录");
            }
            SecurityInfoHolder.setSecurityInfo(securityInfo);
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        //当请求完成时进行删除
        SecurityInfoHolder.removeSecurityInfo();
    }

    /**
     * 判断该请求是否需要认证
     * @param request request
     * @param handler handler
     * @return 返回是否需要认证
     */
    protected boolean authenticationRequired(HttpServletRequest request, Object handler){
        if(handler instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod) handler;
            return hm.hasMethodAnnotation(ApiAuthentication.class) || hm.getBeanType().isAnnotationPresent(ApiAuthentication.class);
        }
        return false;
    }

    /**
     * 认证
     * @param request request
     * @return 返回UserInfo 如果返回为null 会直接认为没有认证
     * @throws AuthenticationException 如果认证失败抛出该异常
     */
    protected SecurityInfo authentication(HttpServletRequest request) throws AuthenticationException {
        String token = this.getRealToken(request);
        if(StringUtils.isEmpty(token)){
            throw new AuthenticationException("请重新登录");
        }


        return null;
    }

    /**
     * 获取请求中存储的header
     * @param request request
     * @return 返回token
     */
    private String getRealToken(HttpServletRequest request){
        return request.getHeader(AUTHENTICATION_HEADER_NAME);
    }


}
