package pers.tom.docwarehouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import pers.tom.docwarehouse.model.entity.Category;

/**
 * @author lijia
 * @description
 * @date 2021/2/3 23:02
 */
public interface CategoryMapper extends BaseMapper<Category> {


    boolean existByName(@Param("name") String name);
}
