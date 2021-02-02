package pers.tom.docwarehouse.listener;

import org.springframework.context.ApplicationEvent;
import pers.tom.docwarehouse.model.entity.OperationLog;

/**
 * @author lijia
 * @description 操作日志事件
 * @date 2021-02-02 10:33
 */
public class OperationLogEvent extends ApplicationEvent {

    private final OperationLog operationLog;

    public OperationLogEvent(OperationLog operationLog) {
        super(operationLog);
        this.operationLog = operationLog;
    }

    public OperationLog getOperationLog() {
        return operationLog;
    }
}
