package pers.tom.docwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.util.CollectionUtils;
import pers.tom.docwarehouse.model.dto.ModuleDto;
import pers.tom.docwarehouse.model.dto.PageResult;
import pers.tom.docwarehouse.model.entity.Module;
import pers.tom.docwarehouse.model.param.ModuleParam;
import pers.tom.docwarehouse.model.param.ModuleQuery;
import pers.tom.docwarehouse.model.param.PageParam;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    List<Module> listBy(ModuleQuery moduleQuery);

    /**
     * 分页查询模块数据
     * @param moduleQuery 条件
     * @param pageParam 分页参数
     * @return 返回list
     */
    PageResult<Module> pageBy(ModuleQuery moduleQuery, PageParam pageParam);

    /**
     * 创建模块
     * @param moduleParam 新增模块参数
     * @return 返回主键
     */
    Long create(ModuleParam moduleParam);

    /**
     * 删除指定模块
     * @return 返回是否删除成功
     */
    boolean removeOne(Long moduleId);

    /**
     * 将entity转换成dto
     * @param module module
     * @return 返回moduleDto
     */
    ModuleDto converterDto(Module module);

    /**
     * 批量转换
     * @param moduleList  moduleList
     * @return 返回moduleDtoList
     */
    default List<ModuleDto> converterDtoList(List<Module> moduleList){
        if(CollectionUtils.isEmpty(moduleList)){
            return Collections.emptyList();
        }

        return moduleList.stream().map(this::converterDto).collect(Collectors.toList());
    }

}
