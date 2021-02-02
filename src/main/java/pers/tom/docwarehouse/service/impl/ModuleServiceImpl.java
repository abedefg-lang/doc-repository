package pers.tom.docwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.tom.docwarehouse.exception.PermissionException;
import pers.tom.docwarehouse.exception.ServiceException;
import pers.tom.docwarehouse.listener.OperationLogEvent;
import pers.tom.docwarehouse.mapper.ModuleMapper;
import pers.tom.docwarehouse.model.dto.ModuleDto;
import pers.tom.docwarehouse.model.entity.Module;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.param.ModuleParam;
import pers.tom.docwarehouse.service.ModuleService;
import pers.tom.docwarehouse.service.OperationLogService;

import java.io.Serializable;

/**
 * @author tom
 * @description
 * @date 2021/1/30 15:45
 */
@Service
@Slf4j
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements ModuleService {


    private final ModuleMapper moduleMapper;

    private final ApplicationEventPublisher eventPublisher;

    public ModuleServiceImpl(ModuleMapper moduleMapper,
                             ApplicationEventPublisher eventPublisher) {
        this.moduleMapper = moduleMapper;
        this.eventPublisher = eventPublisher;
    }


    @Override
    @Transactional
    public Module createModule(ModuleParam moduleParam) {

        //查询该模块是否存在
        String moduleName = moduleParam.getName();
        if(moduleMapper.existByName(moduleName)){
            throw new ServiceException(moduleName+"已存在");
        }
        Module module = moduleParam.converterTo();
        moduleMapper.insert(module);

        //记录用户新增模块日志
        eventPublisher.publishEvent(new OperationLogEvent(new OperationLog("新增模块:"+moduleName)));

        return module;
    }


    @Override
    @Transactional
    public boolean removeById(Serializable id) {
        //判断需要删除模块是否存在
        Module module = getById(id);
        if(module == null){
            throw new ServiceException("模块不存在 请刷新重试");
        }

        if(!module.isCreator()){
            throw new PermissionException("不是该模块的创建人无法删除");
        }

        //删除并且保存日志
        if(super.removeById(id)){
            eventPublisher.publishEvent(new OperationLog("删除模块:"+module.getName()));
            return true;
        }
        return false;
    }

    @Override
    public ModuleDto convertTo(Module module) {
        if(module != null){
            ModuleDto moduleDto = new ModuleDto();
            moduleDto.converterFrom(module);
            return moduleDto;
        }
        return null;
    }
}
