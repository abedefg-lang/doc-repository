package pers.tom.docwarehouse.service;

import pers.tom.docwarehouse.model.dto.OperationLogDto;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.param.OperationLogQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;

import java.util.List;

/**
 * @author lijia
 * @description
 * @date 2021-01-31 14:50
 */
public interface OperationLogService {


    /**
     * 分页条件查询操作日志
     * @param query 查询条件
     * @param pageParam 分页条件
     * @return 返回分页对象
     */
    PageResult<OperationLogDto> pageBy(OperationLogQuery query, PageParam pageParam);

    /**
     * 获取最近的操作日志
     * @param count 日志条数
     * @return 返回list
     */
    List<OperationLogDto> getRecentLogs(Integer count);

    /**
     * 保存记录
     * @param operationLog log
     * @return 返回主键
     */
    Long save(OperationLog operationLog);
}
