package pers.tom.docwarehouse.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pers.tom.docwarehouse.exception.ServiceException;
import pers.tom.docwarehouse.mapper.CategoryMapper;
import pers.tom.docwarehouse.model.dto.CategoryDto;
import pers.tom.docwarehouse.model.entity.Category;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.param.CategoryParam;
import pers.tom.docwarehouse.model.query.CategoryQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.service.CategoryService;
import pers.tom.docwarehouse.service.OperationLogService;
import pers.tom.docwarehouse.utils.CollectionUtils2;

import java.io.Serializable;
import java.util.List;

/**
 * @author tom
 * @description
 * @date 2021/2/3 23:01
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    private final OperationLogService logService;

    public CategoryServiceImpl(OperationLogService logService) {
        this.logService = logService;
    }


    @Override
    @Cacheable(cacheNames = "category", key = "#id")
    public Category getById(Serializable id) {

        return super.getById(id);
    }

    @Override
    public Category createCategory(CategoryParam param) {

        //检查分类是否存在
        String name = param.getName();
        if(baseMapper.existByName(name)){
            throw new ServiceException(name+"已存在");
        }

        Category category = param.converterTo();
        baseMapper.insert(category);

        //写入日志
        logService.saveLog(new OperationLog("创建模块: "+name));

        return category;
    }

    @Override
    public List<CategoryDto> listBy(CategoryQuery categoryQuery) {

        return CollectionUtils2.transform(baseMapper.selectList(categoryQuery.toQueryWrapper()), category -> new CategoryDto().converterFrom(category));
    }

    @Override
    public PageResult<CategoryDto> pageBy(CategoryQuery categoryQuery, PageParam pageParam) {

        Page<Category> page = new Page<>(pageParam.getPage(), pageParam.getPageSize(), pageParam.isSearchTotal());
        baseMapper.selectPage(page, categoryQuery.toQueryWrapper());

        return PageResult.fromIPage(page, category -> new CategoryDto().converterFrom(category));
    }
}
