package pers.tom.docwarehouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import pers.tom.docwarehouse.model.entity.OperationLog;

import java.util.List;

/**
 * @author lijia
 * @description
 * @date 2021-01-31 15:02
 */
public interface OperationLogMapper extends BaseMapper<OperationLog> {

    /**
     * 获取最近的操作记录
     * @param count 条数
     * @return 返回记录数据
     */
    List<OperationLog> selectRecentLog(@Param("count") Integer count);
}
