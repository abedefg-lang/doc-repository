package pers.tom.docwarehouse.exception;

/**
 * @author lijia
 * @description 该项目逻辑异常的顶级异常
 * @date 2021-01-29 14:58
 */
public abstract class DocWarehouseException extends RuntimeException{

    private Object errorData;

    public DocWarehouseException(String message){
        this(message, null);
    }

    public DocWarehouseException(String message, Object errorData) {
        super(message);
        this.errorData = errorData;
    }

    /**
     * 获取状态码 具体状态码交给子类实现
     * @return 返回status
     */
    public abstract Integer getStatus();

    public Object getErrorData() {
        return errorData;
    }

    public void setErrorData(Object errorData) {
        this.errorData = errorData;
    }
}
