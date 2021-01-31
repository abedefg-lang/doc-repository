package pers.tom.docwarehouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.tom.docwarehouse.model.entity.Module;

/**
 * @author lijia
 * @description
 * @date 2021/1/30 15:44
 */
@Repository
public interface ModuleMapper extends BaseMapper<Module> {

    /**
     * 判断模块名是否存在
     * @param name name
     * @return 返回数量
     */
    boolean existByName(@Param("name") String name);

}
