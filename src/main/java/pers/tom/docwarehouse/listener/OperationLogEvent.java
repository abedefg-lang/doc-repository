package pers.tom.docwarehouse.listener;

import org.springframework.context.ApplicationEvent;
import pers.tom.docwarehouse.model.entity.OperationLog;

/**
 * @author lijia
 * @description 操作日志事件
 * @date 2021-01-31 15:17
 */
public class OperationLogEvent extends ApplicationEvent {

    private final OperationLog operationLog;

    public OperationLogEvent(OperationLog source) {
        super(source);
        this.operationLog = source;
    }

    public OperationLog getOperationLog() {
        return operationLog;
    }
}
