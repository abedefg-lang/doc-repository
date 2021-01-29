package pers.tom.docrepository.common.exception;

/**
 * @author lijia
 * @description 该项目逻辑异常的顶级异常
 * @date 2021-01-29 14:58
 */
public class DocWarehouseException extends Exception{


    public DocWarehouseException(String message) {
        super(message);
    }

    public DocWarehouseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DocWarehouseException(Throwable cause) {
        super(cause);
    }

}
