package pers.tom.docwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.tom.docwarehouse.mapper.OperationLogMapper;
import pers.tom.docwarehouse.model.dto.OperationLogDto;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.param.OperationLogQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.service.OperationLogService;
import pers.tom.docwarehouse.utils.CollectionUtils2;

import java.util.List;

/**
 * @author lijia
 * @description
 * @date 2021-01-31 15:01
 */
@Service
@Slf4j
public class OperationLogServiceImpl implements OperationLogService {


    private final OperationLogMapper logMapper;

    public OperationLogServiceImpl(OperationLogMapper logMapper){
        this.logMapper = logMapper;
    }

    @Override
    public PageResult<OperationLogDto> pageBy(OperationLogQuery query, PageParam pageParam) {

        Page<OperationLog> page = new Page<>(pageParam.getPage(), pageParam.getPageSize());
        page.setSearchCount(pageParam.getSearchTotal());
        logMapper.selectPage(page, query.converterTo());

        return PageResult.fromIPage(page, operationLog -> new OperationLogDto().converterFrom(operationLog));
    }

    @Override
    public List<OperationLogDto> getRecentLogs(Integer count) {

        List<OperationLog> operationLogs = logMapper.selectRecentLog(count);
        return CollectionUtils2.transform(operationLogs, operationLog -> new OperationLogDto().converterFrom(operationLog));
    }


    @Override
    public Long save(OperationLog operationLog) {
        logMapper.insert(operationLog);
        return operationLog.getOperationLogId();
    }
}
