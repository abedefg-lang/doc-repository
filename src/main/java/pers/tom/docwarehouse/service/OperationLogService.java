package pers.tom.docwarehouse.service;

import pers.tom.docwarehouse.model.dto.OperationLogDto;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.service.supports.ConvertibleService;

import java.util.List;

/**
 * @author lijia
 * @description
 * @date 2021-01-31 14:50
 */
public interface OperationLogService extends ConvertibleService<OperationLogDto, OperationLog> {


    /**
     * 获取最近的操作日志
     * @param count 日志条数
     * @return 返回list
     */
    List<OperationLog> getRecentLogs(Integer count);


}
