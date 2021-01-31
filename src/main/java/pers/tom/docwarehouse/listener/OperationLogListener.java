package pers.tom.docwarehouse.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pers.tom.docwarehouse.service.OperationLogService;

/**
 * @author lijia
 * @description 操作日志监听器
 *              在执行某些业务的时候需要记录操作日志
 *              但是这个操作日志并不是需要与业务强一致  就算写入日志失败也不能影响业务操作
 *              这里采用发布订阅再异步写入
 * @date 2021-01-31 15:14
 */
@Component
public class OperationLogListener {

    private final OperationLogService operationLogService;

    public OperationLogListener(OperationLogService operationLogService) {
        this.operationLogService = operationLogService;
    }

    @EventListener
    @Async
    public void onApplicationEvent(OperationLogEvent operationLogEvent) {
        operationLogService.save(operationLogEvent.getOperationLog());
    }
}
