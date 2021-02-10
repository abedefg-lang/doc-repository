package pers.tom.docwarehouse.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lijia
 * @description 标志性注解
 *              会对返回结果进行包装进BaseResult
 * @date 2021/1/29 23:55
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PackagingResponse {
}
