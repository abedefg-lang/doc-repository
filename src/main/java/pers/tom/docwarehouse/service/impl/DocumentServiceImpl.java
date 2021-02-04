package pers.tom.docwarehouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.tom.docwarehouse.exception.ServiceException;
import pers.tom.docwarehouse.mapper.DocumentMapper;
import pers.tom.docwarehouse.model.dto.DocumentDto;
import pers.tom.docwarehouse.model.entity.Category;
import pers.tom.docwarehouse.model.entity.Document;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.param.DocumentParam;
import pers.tom.docwarehouse.model.query.DocumentQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.service.CategoryService;
import pers.tom.docwarehouse.service.DocumentService;
import pers.tom.docwarehouse.service.OperationLogService;

import java.util.List;

/**
 * @author lijia
 * @description
 * @date 2021-02-04 11:11
 */
@Service
public class DocumentServiceImpl extends ServiceImpl<DocumentMapper, Document> implements DocumentService {

    private final OperationLogService logService;

    private final CategoryService categoryService;

    public DocumentServiceImpl(OperationLogService logService,
                               CategoryService categoryService) {
        this.logService = logService;
        this.categoryService = categoryService;
    }

    @Override
    @Transactional
    public Document create(DocumentParam documentParam) {

        //判断文档标题是否存在
        String title = documentParam.getTitle();
        if(baseMapper.existByTitle(title)){
            throw new ServiceException(title + "已存在");
        }

        Document document = documentParam.converterTo();
        baseMapper.insert(document);

        //写入日志
        logService.saveLog(new OperationLog("创建文档: " + title));

        return document;
    }

    @Override
    public boolean edit(DocumentParam newDocument, Long documentId) {

        //判断文档标题是否存在
//        String title = newDocument.getTitle();
//        if(baseMapper.existByTitle(title)){
//            throw new ServiceException(title + "已存在");
//        }

        //写入日志
//        logService.saveLog(new OperationLog("编辑文档: " + title));
        return false;
    }

    @Override
    public DocumentDto details(Long documentId) {

        Document document = baseMapper.selectById(documentId);
        if(document == null){
            throw new ServiceException("找不到文档 请刷新重试");
        }
        return converterTo(document);
    }

    @Override
    public PageResult<DocumentDto> pageBy(DocumentQuery documentQuery, PageParam pageParam) {

        Page<Document> page = new Page<>(pageParam.getPage(), pageParam.getPageSize(), pageParam.isSearchTotal());
        QueryWrapper<Document> queryWrapper = documentQuery.toQueryWrapper();

        //设置查询字段不包含内容
        queryWrapper.select("`document_id`", "`category_id`", "`title`", "`content_overview`", "`created_by`", "`creator_id`", "`create_time`", "`updated_by`", "`updater_id`", "`update_time`");
        baseMapper.selectPage(page, queryWrapper);

        return PageResult.fromIPage(page, this::converterTo);
    }

    @Override
    public List<DocumentDto> getMyDocument() {


        return null;
    }

    private DocumentDto converterTo(Document document){

        if(document != null){

            DocumentDto documentDto = new DocumentDto().converterFrom(document);
            Category category = categoryService.getById(document.getCategoryId());
            documentDto.setCategoryName(category == null ? "" : category.getName());
            return documentDto;
        }

        return null;
    }
}
