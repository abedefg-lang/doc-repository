package pers.tom.docwarehouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import pers.tom.docwarehouse.model.entity.Document;

import java.util.List;

/**
 * @author lijia
 * @description
 * @date 2021-02-04 11:08
 */
public interface DocumentMapper extends BaseMapper<Document> {

    /**
     * 判断是否已存在标题
     * @param title title
     * @return 返回是否存在
     */
    boolean existByTitle(@Param("title") String title);

    /**
     * 通过创建人id查询
     * @param creatorId 创建人id
     * @return 返回文档数据
     */
    List<Document> selectByCreatorId(@Param("creatorId") Long creatorId);
}
