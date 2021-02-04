package pers.tom.docwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.tom.docwarehouse.model.dto.DocumentDto;
import pers.tom.docwarehouse.model.entity.Document;
import pers.tom.docwarehouse.model.param.DocumentParam;
import pers.tom.docwarehouse.model.query.DocumentQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;

import java.util.List;

/**
 * @author lijia
 * @description
 * @date 2021-02-04 11:10
 */
public interface DocumentService extends IService<Document> {

    /**
     * 创建文档
     * @param documentParam 文档参数
     * @return 返回创建的文档
     */
    Document create(DocumentParam documentParam);

    /**
     * 编辑文档
     * @param newDocument 新文档
     * @param documentId 主键
     * @return 返回是否编辑成功
     */
    boolean edit(DocumentParam newDocument, Long documentId);

    /**
     * 查询文档详情 包含文档内容
     * @param documentId 主键
     * @return 返回dto
     */
    DocumentDto details(Long documentId);

    /**
     * 分页查询文档
     * @param documentQuery 查询条件
     * @param pageParam 分页参数
     * @return 返回分页结果
     */
    PageResult<DocumentDto> pageBy(DocumentQuery documentQuery, PageParam pageParam);

    /**
     * 获取由我创建的文档
     * @return 返回list
     */
    List<DocumentDto> getMyDocument();
}
