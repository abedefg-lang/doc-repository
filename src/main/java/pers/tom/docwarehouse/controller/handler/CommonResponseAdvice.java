package pers.tom.docwarehouse.controller.handler;


import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import pers.tom.docwarehouse.annotation.PackagingResponse;
import pers.tom.docwarehouse.model.supports.BaseResult;

import javax.validation.constraints.NotNull;

/**
 * @author lijia
 * @description 统一返回值处理
 * @date 2020-11-11 17:01
 */
@RestControllerAdvice
public class CommonResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(@NotNull MethodParameter methodParameter,
                            @NotNull Class<? extends HttpMessageConverter<?>> aClass) {

        //判断方法返回结果是否可以转为json 再判断方法，类上面是否含有PackagingResponse注解
        return AbstractJackson2HttpMessageConverter.class.isAssignableFrom(aClass)
                && (methodParameter.hasMethodAnnotation(PackagingResponse.class)
                || methodParameter.getDeclaringClass().isAnnotationPresent(PackagingResponse.class));
    }

    @Override
    public Object beforeBodyWrite(Object o,
                                  @NotNull MethodParameter methodParameter,
                                  @NotNull MediaType mediaType,
                                  @NotNull Class<? extends HttpMessageConverter<?>> aClass,
                                  @NotNull ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        //判断结果是否是BaseResult 如果不是BaseResult进行封装
        if(o instanceof BaseResult){
            Integer status = ((BaseResult<?>) o).getStatus();
            serverHttpResponse.setStatusCode(HttpStatus.valueOf(status));
            return o;
        }

        BaseResult<?> baseResult = BaseResult.ok(o);
        serverHttpResponse.setStatusCode(HttpStatus.OK);
        return baseResult;
    }
}
