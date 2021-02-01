package pers.tom.docwarehouse.exception;

/**
 * @author lijia
 * @description 权限异常
 * @date 2021-02-01 12:23
 */
public class PermissionException extends DocWarehouseException{


    public PermissionException(String message) {
        super(message);
    }

    @Override
    public Integer getStatus() {
        return null;
    }
}
