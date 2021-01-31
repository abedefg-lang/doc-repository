package pers.tom.docwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.tom.docwarehouse.model.dto.ModuleDto;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.model.entity.Module;
import pers.tom.docwarehouse.model.param.ModuleQuery;
import pers.tom.docwarehouse.model.supports.PageParam;

import java.util.List;

/**
 * @author lijia
 * @description
 * @date 2021/1/30 15:45
 */
public interface ModuleService extends IService<Module> {

    /**
     * 条件查询模块数据
     * @param moduleQuery 条件查询模块数据
     * @return 返回list
     */
    List<ModuleDto> listBy(ModuleQuery moduleQuery);

    /**
     * 分页查询模块数据
     * @param moduleQuery 条件
     * @param pageParam 分页参数
     * @return 返回list
     */
    PageResult<ModuleDto> pageBy(ModuleQuery moduleQuery, PageParam pageParam);



}
