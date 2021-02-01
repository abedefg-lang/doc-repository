package pers.tom.docwarehouse.controller.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.tom.docwarehouse.exception.DocWarehouseException;
import pers.tom.docwarehouse.model.dto.base.BaseResult;
import pers.tom.docwarehouse.utils.CollectionUtils2;

import java.util.List;

/**
 * @author lijia
 * @description 全局异常处理器
 * @date 2021-01-29 15:04
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult<?> handleValidException(MethodArgumentNotValidException validException){

        BaseResult<?> result = handleException(validException);
        result.setStatus(HttpStatus.BAD_REQUEST.value());

        handleBindingResult(validException.getBindingResult(), result);
        return result;
    }

    @ExceptionHandler(BindException.class)
    public BaseResult<?> handleBindException(BindException bindException){

        BaseResult<?> result = handleException(bindException);
        result.setStatus(HttpStatus.BAD_REQUEST.value());

        handleBindingResult(bindException.getBindingResult(), result);
        return result;
    }

    @ExceptionHandler(DocWarehouseException.class)
    public BaseResult<?> handleDocWarehouseException(DocWarehouseException docWarehouseException){
        BaseResult<?> result = handleException(docWarehouseException);
        result.setStatus(docWarehouseException.getStatus());
        result.setMessage(docWarehouseException.getMessage());
        return result;
    }

    /**
     * 处理参数绑定异常的结果 返回message
     * @param bindingResult 绑定结果
     * @param baseResult result
     */
    private void handleBindingResult(BindingResult bindingResult, BaseResult<?> baseResult){

        if(bindingResult != null){
            //获取参数验证错误结果  只取第一个信息
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            if(!CollectionUtils2.isEmpty(fieldErrors)){
                FieldError firstError = fieldErrors.get(0);
                baseResult.setMessage(firstError.getField() + firstError.getDefaultMessage());
            }
        }
    }


    private BaseResult<?> handleException(Throwable throwable){
        log.error("Exception: ", throwable);
        BaseResult<?> baseResult = new BaseResult<>();
        baseResult.setMessage(throwable.getMessage());
        return baseResult;
    }
}
