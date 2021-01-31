package pers.tom.docwarehouse.service;

import pers.tom.docwarehouse.model.dto.ModuleDto;
import pers.tom.docwarehouse.model.param.ModuleParam;
import pers.tom.docwarehouse.model.param.ModuleQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;

import java.util.List;

/**
 * @author lijia
 * @description
 * @date 2021/1/30 15:45
 */
public interface ModuleService {

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

    /**
     * 创建模块
     * @param module module
     * @return 返回主键
     */
    Long create(ModuleParam module);
}
