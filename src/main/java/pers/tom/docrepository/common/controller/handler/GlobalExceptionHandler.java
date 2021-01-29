package pers.tom.docrepository.common.controller.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lijia
 * @description 全局异常处理器
 * @date 2021-01-29 15:04
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public Rsp<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException supportedException){
//        Rsp<?> rsp = handleException(supportedException);
//        rsp.setMessage(supportedException.getMessage());
//        return rsp;
//    }
//
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    public Rsp<?> handleMissingServletRequestParameterException(MissingServletRequestParameterException parameterException){
//        Rsp<?> rsp = handleException(parameterException);
//        rsp.setStatus(HttpStatus.OK.value());
//        rsp.setMessage("请检查必传参数");
//        return rsp;
//    }
//
//    /**
//     * 处理方法参数验证异常
//     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Rsp<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException validException) {
//        BindingResult bindingResult = validException.getBindingResult();
//        FieldError fieldError = bindingResult.getFieldErrors().get(0);
//        Rsp<?> rsp = handleException(validException);
//        rsp.setStatus(HttpStatus.OK.value());
//        rsp.setMessage(fieldError.getField() + fieldError.getDefaultMessage());
//        return rsp;
//    }
//
//    /**
//     * 处理参数造型异常
//     */
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public Rsp<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException mismatchException){
//        Rsp<?> rsp = handleException(mismatchException);
//        rsp.setStatus(HttpStatus.OK.value());
//        rsp.setMessage(mismatchException.getName() + "类型错误");
//        return rsp;
//    }
//
//    /**
//     * 处理读取json数据异常
//     */
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public Rsp<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException readableException){
//        Rsp<?> rsp = handleException(readableException);
//        rsp.setMessage("请求缺失主体 请重试");
//        rsp.setStatus(HttpStatus.OK.value());
//        return rsp;
//    }
//
//    /**
//     * 处理参数绑定异常 校验异常
//     */
//    @ExceptionHandler(BindException.class)
//    public Rsp<?> handleBindException(BindException bindException){
//        BindingResult bindingResult = bindException.getBindingResult();
//        FieldError fieldError = bindingResult.getFieldErrors().get(0);
//        Rsp<?> rsp = handleException(bindException);
//        rsp.setStatus(HttpStatus.OK.value());
//        rsp.setMessage(fieldError.getField() + fieldError.getDefaultMessage());
//        return rsp;
//    }

}
