package pers.tom.docwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.tom.docwarehouse.model.dto.OperationLogDto;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.param.OperationLogQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.service.supports.BaseService;

import java.util.List;

/**
 * @author lijia
 * @description
 * @date 2021-01-31 14:50
 */
public interface OperationLogService extends BaseService<OperationLogDto, OperationLog> {


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


}
