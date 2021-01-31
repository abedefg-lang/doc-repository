package pers.tom.docwarehouse.controller.supports;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.tom.docwarehouse.exception.DocWarehouseException;
import pers.tom.docwarehouse.model.supports.BaseResult;

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

        //获取参数验证错误结果  只取第一个信息
        BindingResult bindingResult = validException.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if(!CollectionUtils.isEmpty(fieldErrors)){
            FieldError firstError = fieldErrors.get(0);
            result.setMessage(firstError.getField() + firstError.getDefaultMessage());
        }

        return result;
    }

    @ExceptionHandler(DocWarehouseException.class)
    public BaseResult<?> handleDocWarehouseException(DocWarehouseException docWarehouseException){
        BaseResult<?> result = handleException(docWarehouseException);
        result.setStatus(docWarehouseException.getStatus());
        result.setMessage(docWarehouseException.getMessage());
        return result;
    }



    private BaseResult<?> handleException(Throwable throwable){
        log.error("Exception: ", throwable);
        BaseResult<?> baseResult = new BaseResult<>();
        baseResult.setMessage(throwable.getMessage());
        return baseResult;
    }
}
