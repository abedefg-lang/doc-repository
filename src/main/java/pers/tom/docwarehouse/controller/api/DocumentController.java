package pers.tom.docwarehouse.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pers.tom.docwarehouse.annotation.ApiAuthentication;
import pers.tom.docwarehouse.annotation.PackagingResponse;
import pers.tom.docwarehouse.model.dto.DocumentDto;
import pers.tom.docwarehouse.model.dto.DocumentVersionDto;
import pers.tom.docwarehouse.model.param.DocumentParam;
import pers.tom.docwarehouse.model.query.DocumentQuery;
import pers.tom.docwarehouse.model.supports.BaseResult;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.security.SecurityInfoHolder;
import pers.tom.docwarehouse.service.DocumentService;
import pers.tom.docwarehouse.service.DocumentVersionService;

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

    private final DocumentVersionService versionService;

    public DocumentController(DocumentService documentService,
                              DocumentVersionService versionService) {
        this.documentService = documentService;
        this.versionService = versionService;
    }

    @PostMapping
    @ApiOperation("创建文档")
    public BaseResult<Long> create(@RequestBody @Valid DocumentParam documentParam){

        return BaseResult.ok(documentService.create(documentParam).getDocumentId());
    }

    @PutMapping("/{documentId}")
    @ApiOperation("编辑文档")
    public BaseResult<Boolean> edit(@RequestBody DocumentParam documentParam,
                                    @PathVariable("documentId") Long documentId){

        return BaseResult.ok(documentService.edit(documentParam, documentId));
    }


    @GetMapping("/{documentId}")
    @ApiOperation("查看单个文档详情 包含文档内容")
    public DocumentDto documentDetail(@PathVariable("documentId") Long documentId){

        return documentService.details(documentId);
    }

    @GetMapping("/pageBy")
    @ApiOperation("分页查询文档信息 返回数据不包含文档内容")
    public PageResult<DocumentDto> documentPageBy(DocumentQuery documentQuery,
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

    @GetMapping("/{documentId}/version/pageBy")
    @ApiOperation("分页查询指定文档的历史版本  不包含文档内容")
    public PageResult<DocumentVersionDto> versionPageBy(@PathVariable("documentId") Long documentId,
                                                        @Valid PageParam pageParam){

        return versionService.pageBy(documentId, pageParam);
    }

    @GetMapping("/version/{versionId}")
    @ApiOperation("查看某个版本详细内容 包含文档内容")
    public DocumentVersionDto versionDetail(@PathVariable("versionId") Long versionId){

        return versionService.getOne(versionId);
    }

    @PutMapping("/revert")
    @ApiOperation("将文档内容 内容概述回退到指定版本")
    public BaseResult<Boolean> revert(@RequestParam("versionId") Long versionId){

        return BaseResult.ok(documentService.revert(versionId));
    }

}
