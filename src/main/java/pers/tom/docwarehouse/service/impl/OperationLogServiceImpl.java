package pers.tom.docwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.tom.docwarehouse.mapper.OperationLogMapper;
import pers.tom.docwarehouse.model.dto.OperationLogDto;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.param.OperationLogQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.service.OperationLogService;

import java.util.List;

/**
 * @author lijia
 * @description
 * @date 2021-01-31 15:01
 */
@Service
@Slf4j
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements OperationLogService {

    @Override
    public PageResult<OperationLogDto> pageBy(OperationLogQuery query, PageParam pageParam) {

        Page<OperationLog> page = new Page<>(pageParam.getPage(), pageParam.getPageSize());
        page.setSearchCount(pageParam.getSearchTotal());
        page(page, query.converterTo());

        PageResult<OperationLogDto> pageResult = new PageResult<>();
        pageResult.setTotal(page.getTotal());
        pageResult.setList(converterList(page.getRecords()));
        return pageResult;
    }

    @Override
    public List<OperationLogDto> getRecentLogs(Integer count) {

        return converterList(baseMapper.selectRecentLog(count));
    }

    @Override
    public OperationLogDto converterTo(OperationLog log){
        if(log != null){
            OperationLogDto operationLogDto = new OperationLogDto();
            operationLogDto.converterFrom(log);
            return operationLogDto;
        }
        return null;
    }



}
