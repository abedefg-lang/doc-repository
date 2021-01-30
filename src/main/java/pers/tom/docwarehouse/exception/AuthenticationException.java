package pers.tom.docwarehouse.exception;

import org.springframework.http.HttpStatus;

/**
 * @author tom
 * @description 认证异常
 * @date 2021/1/30 22:07
 */
public class AuthenticationException extends DocWarehouseException{

    public AuthenticationException(String message) {
        super(message);
    }

    @Override
    public Integer getStatus() {
        return HttpStatus.UNAUTHORIZED.value();
    }
}
