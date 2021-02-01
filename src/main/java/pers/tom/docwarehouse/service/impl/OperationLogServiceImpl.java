package pers.tom.docwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.tom.docwarehouse.mapper.OperationLogMapper;
import pers.tom.docwarehouse.model.dto.OperationLogDto;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.security.SecurityInfo;
import pers.tom.docwarehouse.security.SecurityInfoHolder;
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
    public List<OperationLog> getRecentLogs(Integer count) {

        return baseMapper.selectRecentLog(count);
    }

    @Override
    @Transactional
    public boolean save(OperationLog operationLog) {

        //设置操作人与操作时间
        SecurityInfo securityInfo = SecurityInfoHolder.getSecurityInfo();
        operationLog.setOperator(securityInfo == null ? "" : securityInfo.getUsername());
        operationLog.setOperationTime(System.currentTimeMillis());

        return SqlHelper.retBool(baseMapper.insert(operationLog));
    }


    @Override
    public OperationLogDto convertTo(OperationLog operationLog) {
        if(operationLog != null){
            OperationLogDto logDto = new OperationLogDto();
            logDto.converterFrom(operationLog);
            return logDto;
        }
        return null;
    }
}
