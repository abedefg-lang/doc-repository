package pers.tom.docwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.tom.docwarehouse.exception.ServiceException;
import pers.tom.docwarehouse.mapper.ModuleMapper;
import pers.tom.docwarehouse.model.dto.ModuleDto;
import pers.tom.docwarehouse.model.dto.PageResult;
import pers.tom.docwarehouse.model.entity.Module;
import pers.tom.docwarehouse.model.param.ModuleParam;
import pers.tom.docwarehouse.model.param.ModuleQuery;
import pers.tom.docwarehouse.model.param.PageParam;
import pers.tom.docwarehouse.service.ModuleService;

import java.util.List;

/**
 * @author tom
 * @description
 * @date 2021/1/30 15:45
 */
@Service
@Slf4j
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements ModuleService {


    @Override
    public List<Module> listBy(ModuleQuery moduleQuery) {

        return list(moduleQuery.converterTo());
    }

    @Override
    public PageResult<Module> pageBy(ModuleQuery moduleQuery, PageParam pageParam) {
        return null;
    }

    @Override
    public Long create(ModuleParam moduleParam) {

        //判断名字是否存在
        if(baseMapper.existByName(moduleParam.getName())){
            throw new ServiceException(moduleParam.getName()+"模块已存在");
        }
        Module module = moduleParam.converterTo();
        save(module);
        return module.getModuleId();
    }

    @Override
    public boolean removeOne(Long moduleId){

        //TODO 判断执行该操作的是否是该模块的创建人
        Module module = getById(moduleId);
        if(module == null){
            throw new ServiceException("找不到该模块请刷新重试");
        }
        return removeById(moduleId);
    }


    @Override
    public ModuleDto converterDto(Module module) {

        if(module != null){
            ModuleDto moduleDto = new ModuleDto();
            moduleDto.converterFrom(module);
            return moduleDto;
        }
        return null;
    }
}
