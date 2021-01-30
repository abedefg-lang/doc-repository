package pers.tom.docwarehouse.annotation;

import java.lang.annotation.*;

/**
 * @author lijia
 * @description api认证  标志性注解
 *              会拦截标识了该注解的api  判断是否有登录
 *              如果没有登录会抛出{@link pers.tom.docwarehouse.exception.AuthenticationException}
 * @date 2021/1/30 22:03
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiAuthentication {
}
