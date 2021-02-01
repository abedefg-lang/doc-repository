package pers.tom.docwarehouse.service;

import pers.tom.docwarehouse.model.dto.ModuleDto;
import pers.tom.docwarehouse.model.entity.Module;
import pers.tom.docwarehouse.model.param.ModuleParam;
import pers.tom.docwarehouse.service.supports.ConvertibleService;

/**
 * @author lijia
 * @description
 * @date 2021/1/30 15:45
 */
public interface ModuleService extends ConvertibleService<ModuleDto, Module> {


    /**
     * 创建模块
     * @param module module
     * @return 返回主键
     */
    Module createModule(ModuleParam module);


}
