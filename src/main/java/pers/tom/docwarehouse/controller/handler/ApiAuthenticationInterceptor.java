package pers.tom.docwarehouse.controller.handler;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pers.tom.docwarehouse.annotation.ApiAuthentication;
import pers.tom.docwarehouse.config.properties.JwtConfiguration;
import pers.tom.docwarehouse.exception.AuthenticationException;
import pers.tom.docwarehouse.model.entity.User;
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
@Slf4j
public class ApiAuthenticationInterceptor implements HandlerInterceptor {

    public static final String AUTHENTICATION_HEADER_NAME = "Authorization";

    private final UserService userService;

//    private final JwtConfiguration jwtConfiguration;

    private final JWTVerifier verifier;

    public ApiAuthenticationInterceptor(UserService userService,
                                        JwtConfiguration jwtConfiguration){
        this.userService = userService;
//        this.jwtConfiguration = jwtConfiguration;
        this.verifier = JWT.require(Algorithm.HMAC256(jwtConfiguration.getSecretKey())).build();
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
        if(!StringUtils.isEmpty(token)){
            try{
                //验证token
                DecodedJWT decoded = verifier.verify(token);
                Claim claim = decoded.getClaim("userId");
                if(claim != null){
                    //查询user
                    User user = userService.getById(claim.asLong());
                    return user == null ? null : new SecurityInfo(user.getUserId(), user.getUsername());
                }
            }catch (Exception e){
                log.error("Token exception: ", e);
                throw new AuthenticationException("请重新登录");
            }
        }

        //如果上面没有进行返回 抛出一次囊
        throw new AuthenticationException("请重新登录");
    }

    /**
     * 获取请求中存储的header
     * @param request request
     * @return 返回token
     */
    private String getRealToken(HttpServletRequest request){
        String headerValue = request.getHeader(AUTHENTICATION_HEADER_NAME);
        if(!StringUtils.isEmpty(headerValue)){
            String[] headerValueArr = headerValue.split(" ");
            return headerValueArr.length >= 2 ? headerValueArr[1] : null;
        }
        return null;
    }


}
