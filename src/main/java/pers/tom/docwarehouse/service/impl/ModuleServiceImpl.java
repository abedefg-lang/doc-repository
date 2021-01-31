package pers.tom.docwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.tom.docwarehouse.mapper.ModuleMapper;
import pers.tom.docwarehouse.model.dto.ModuleDto;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.model.entity.Module;
import pers.tom.docwarehouse.model.param.ModuleQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
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
    public List<ModuleDto> listBy(ModuleQuery moduleQuery) {
        return null;
    }

    @Override
    public PageResult<ModuleDto> pageBy(ModuleQuery moduleQuery, PageParam pageParam) {
        return null;
    }
}
