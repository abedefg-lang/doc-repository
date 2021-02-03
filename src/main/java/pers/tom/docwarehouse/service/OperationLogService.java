package pers.tom.docwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.tom.docwarehouse.model.dto.OperationLogDto;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.query.OperationLogQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;

import java.util.List;

/**
 * @author lijia
 * @description
 * @date 2021/2/3 0:14
 */
public interface OperationLogService extends IService<OperationLog> {

    /**
     * 保存日志
     * @param operationLog 日志对象
     */
    void saveLog(OperationLog operationLog);

    /**
     * 获取最近日志
     * @param count 数量
     * @return 返回list
     */
    List<OperationLogDto> getRecentLog(Integer count);

    /**
     * 分页查询满足条件的日志数据
     * @param logQuery 日志查询对象
     * @return 返回分页对象
     */
    PageResult<OperationLogDto> pageBy(OperationLogQuery logQuery, PageParam pageParam);
}
