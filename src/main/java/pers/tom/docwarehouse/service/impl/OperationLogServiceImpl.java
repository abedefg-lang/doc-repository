package pers.tom.docwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pers.tom.docwarehouse.mapper.OperationLogMapper;
import pers.tom.docwarehouse.model.dto.OperationLogDto;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.query.OperationLogQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.service.OperationLogService;
import pers.tom.docwarehouse.utils.CollectionUtils2;

import java.util.List;

/**
 * @author tom
 * @description
 * @date 2021/2/3 0:25
 */
@Service
@Slf4j
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements OperationLogService {

    /**
     * 异步写入日志 不能让写入日志影响到已完成的操作
     */
    @Async
    @Override
    public void saveLog(OperationLog operationLog) {

        log.info("{} : {}", operationLog.getCreatedBy(), operationLog.getInfo());
        baseMapper.insert(operationLog);
    }

    @Override
    public List<OperationLogDto> getRecentLog(Integer count) {

        return CollectionUtils2.transform(baseMapper.selectRecentLog(count), operationLog -> new OperationLogDto().converterFrom(operationLog));
    }

    @Override
    public PageResult<OperationLogDto> pageBy(OperationLogQuery logQuery, PageParam pageParam) {

        Page<OperationLog> page = new Page<>(pageParam.getPage(), pageParam.getPageSize(), pageParam.isSearchTotal());
        baseMapper.selectPage(page, logQuery.toQueryWrapper());

        return PageResult.fromIPage(page, operationLog -> new OperationLogDto().converterFrom(operationLog));
    }


}
