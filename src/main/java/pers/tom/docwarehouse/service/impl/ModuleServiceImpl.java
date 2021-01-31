package pers.tom.docwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import pers.tom.docwarehouse.exception.ServiceException;
import pers.tom.docwarehouse.listener.OperationLogEvent;
import pers.tom.docwarehouse.mapper.ModuleMapper;
import pers.tom.docwarehouse.model.dto.ModuleDto;
import pers.tom.docwarehouse.model.entity.Module;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.param.ModuleParam;
import pers.tom.docwarehouse.model.param.ModuleQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.service.ModuleService;
import pers.tom.docwarehouse.utils.CollectionUtils2;

import java.util.List;

/**
 * @author tom
 * @description
 * @date 2021/1/30 15:45
 */
@Service
@Slf4j
public class ModuleServiceImpl  implements ModuleService {


    private final ModuleMapper moduleMapper;

    private final ApplicationEventPublisher applicationEventPublisher;

    public ModuleServiceImpl(ApplicationEventPublisher applicationEventPublisher,
                             ModuleMapper moduleMapper) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.moduleMapper = moduleMapper;
    }

    @Override
    public List<ModuleDto> listBy(ModuleQuery moduleQuery) {

        List<Module> modules = moduleMapper.selectList(moduleQuery.converterTo());
        return CollectionUtils2.transform(modules, module -> new ModuleDto().converterFrom(module));
    }

    @Override
    public PageResult<ModuleDto> pageBy(ModuleQuery moduleQuery, PageParam pageParam) {

        Page<Module> page = new Page<>(pageParam.getPage(), pageParam.getPageSize());
        page.setSearchCount(pageParam.getSearchTotal());
        moduleMapper.selectPage(page, moduleQuery.converterTo());

        return PageResult.fromIPage(page, module -> new ModuleDto().converterFrom(module));
    }

    @Override
    public Long create(ModuleParam moduleParam) {

        //查询该模块是否存在
        String moduleName = moduleParam.getName();
        if(moduleMapper.existByName(moduleName)){
            throw new ServiceException(moduleName+"已存在");
        }
        Module module = moduleParam.converterTo();
        moduleMapper.insert(module);

        //发布创建模块事件
        applicationEventPublisher.publishEvent(new OperationLogEvent(new OperationLog("save", "新增模块:"+moduleName)));
        return module.getModuleId();
    }

}
