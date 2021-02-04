package pers.tom.docwarehouse.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pers.tom.docwarehouse.annotation.ApiAuthentication;
import pers.tom.docwarehouse.annotation.PackagingResponse;
import pers.tom.docwarehouse.model.dto.DocumentDto;
import pers.tom.docwarehouse.model.param.DocumentParam;
import pers.tom.docwarehouse.model.query.DocumentQuery;
import pers.tom.docwarehouse.model.supports.BaseResult;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.security.SecurityInfoHolder;
import pers.tom.docwarehouse.service.DocumentService;

import javax.validation.Valid;

/**
 * @author lijia
 * @description
 * @date 2021-02-04 11:13
 */
@RestController
@RequestMapping("/api/documents")
@Api(tags = "文档接口")
@ApiAuthentication
@PackagingResponse
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    @ApiOperation("创建文档")
    public BaseResult<Long> create(@RequestBody @Valid DocumentParam documentParam){

        return BaseResult.ok(documentService.create(documentParam).getDocumentId());
    }

//    @PutMapping("/{documentId}")
    @ApiOperation("编辑文档")
    public BaseResult<Boolean> edit(@RequestBody DocumentParam newDocument,
                                    @PathVariable("documentId") Long documentId){

        return BaseResult.ok(documentService.edit(newDocument, documentId));
    }


    @GetMapping("/{documentId}")
    @ApiOperation("查看单个文档详情 包含文档内容")
    public DocumentDto getOne(@PathVariable("documentId") Long documentId){

        return documentService.details(documentId);
    }

    @GetMapping("/pageBy")
    @ApiOperation("分页查询文档信息 返回数据不包含文档内容")
    public PageResult<DocumentDto> pageBy(DocumentQuery documentQuery,
                                          @Valid PageParam pageParam){

        return documentService.pageBy(documentQuery, pageParam);
    }

    @GetMapping("/my")
    @ApiOperation("获取由我创建的文档")
    public PageResult<DocumentDto> getMyDoc(@Valid PageParam pageParam){

        //创建查询文档参数
        DocumentQuery documentQuery = new DocumentQuery();
        documentQuery.setCreatorId(SecurityInfoHolder.getSecurityInfo().getIdentity());
        return documentService.pageBy(documentQuery, pageParam);
    }

}
