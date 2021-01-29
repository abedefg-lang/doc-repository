package pers.tom.docrepository.common.log;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lijia
 * @description 放置该注解的方法会记录日志(参数，返回值)
 *              如果放置在类上 该类所有方法都会记录日志
 * @date 2021-01-25 10:37
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAble {


}
