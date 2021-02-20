package pers.tom.docwarehouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import pers.tom.docwarehouse.model.entity.Document;


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
    Document selectByTitle(@Param("title") String title);

}
