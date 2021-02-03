package pers.tom.docwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.tom.docwarehouse.model.dto.CategoryDto;
import pers.tom.docwarehouse.model.entity.Category;
import pers.tom.docwarehouse.model.param.CategoryParam;
import pers.tom.docwarehouse.model.query.CategoryQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;

import java.util.List;

/**
 * @author tom
 * @description
 * @date 2021/2/3 23:01
 */
public interface CategoryService extends IService<Category> {

    /**
     * 创建分类
     * @param param param
     * @return 返回创建的分类
     */
    Category createCategory(CategoryParam param);


    /**
     * 条件查询分类数据
     * @param categoryQuery 查询条件
     * @return 返回list
     */
    List<CategoryDto> listBy(CategoryQuery categoryQuery);


    /**
     * 分页查询分类数据
     * @param categoryQuery 查询条件
     * @param pageParam 分页参数
     * @return 返回分页结果
     */
    PageResult<CategoryDto> pageBy(CategoryQuery categoryQuery, PageParam pageParam);
}
