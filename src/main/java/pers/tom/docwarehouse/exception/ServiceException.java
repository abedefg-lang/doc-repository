package pers.tom.docwarehouse.exception;

import org.springframework.http.HttpStatus;

/**
 * @author tom
 * @description 业务异常
 * @date 2021/1/30 16:03
 */
public class ServiceException extends DocWarehouseException{


    public ServiceException(String message) {
        super(message);
    }


    public ServiceException(String message, Object errorData){
        super(message, errorData);
    }


    @Override
    public Integer getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
}
