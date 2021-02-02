package pers.tom.docwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.tom.docwarehouse.mapper.OperationLogMapper;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.service.OperationLogService;

/**
 * @author tom
 * @description
 * @date 2021/2/3 0:25
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements OperationLogService {
}
