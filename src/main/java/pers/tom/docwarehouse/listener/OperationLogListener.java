package pers.tom.docwarehouse.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.service.OperationLogService;


/**
 * @author lijia
 * @description 操作日志监听器
 *              在写入操作日志的时候会产生异常 操作日志并不需要强一致
 *              不能让操作日志的写入失败影响到之前已经执行成功的操作
 *              这里采用发布订阅  然后异步写入日志
 * @date 2021-02-02 10:34
 */
@Component
public class OperationLogListener implements ApplicationListener<OperationLogEvent> {

    private final OperationLogService logService;

    public OperationLogListener(OperationLogService logService) {
        this.logService = logService;
    }

    @Override
    @Async
    public void onApplicationEvent(OperationLogEvent operationLogEvent) {
        OperationLog operationLog = operationLogEvent.getOperationLog();
        if(operationLog != null){
            logService.save(operationLog);
        }
    }
}
