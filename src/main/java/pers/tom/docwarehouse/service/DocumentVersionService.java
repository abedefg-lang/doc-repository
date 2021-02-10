package pers.tom.docwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.tom.docwarehouse.model.dto.DocumentVersionDto;
import pers.tom.docwarehouse.model.entity.DocumentVersion;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;

/**
 * @author lijia
 * @description
 * @date 2021/2/9 12:57
 */
public interface DocumentVersionService extends IService<DocumentVersion> {

    /**
     * 获取指定文档版本的数据
     * @param versionId 主键id
     * @return 返回数据
     */
    DocumentVersionDto getOne(Long versionId);

    /**
     * 分页查询指定文档版本记录
     * @param documentId 文档id
     * @param pageParam 分页参数
     * @return 返回分页结果
     */
    PageResult<DocumentVersionDto> pageBy(Long documentId, PageParam pageParam);
}
