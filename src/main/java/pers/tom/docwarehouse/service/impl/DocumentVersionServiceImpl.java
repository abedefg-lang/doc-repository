package pers.tom.docwarehouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.tom.docwarehouse.exception.ServiceException;
import pers.tom.docwarehouse.mapper.DocumentVersionMapper;
import pers.tom.docwarehouse.model.dto.DocumentVersionDto;
import pers.tom.docwarehouse.model.entity.DocumentVersion;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.service.DocumentVersionService;


/**
 * @author tom
 * @description
 * @date 2021/2/9 12:58
 */
@Service
public class DocumentVersionServiceImpl extends ServiceImpl<DocumentVersionMapper, DocumentVersion> implements DocumentVersionService {

    @Override
    public DocumentVersionDto getOne(Long versionId) {

        DocumentVersion version = this.getById(versionId);
        if(version == null){
            throw new ServiceException("找不到该版本 请刷新重试");
        }

        return new DocumentVersionDto().converterFrom(version);
    }

    @Override
    public PageResult<DocumentVersionDto> pageBy(Long documentId, PageParam pageParam) {

        QueryWrapper<DocumentVersion> queryWrapper = new QueryWrapper<>();
        //设置查询字段  不需要查询出内容
        queryWrapper.select("`document_version_id`", "`document_id`", "`content_overview`", "`created_by`", "`creator_id`", "`create_time`")
                .eq("`document_id`", documentId)
                .orderByDesc("create_time");

        Page<DocumentVersion> page = new Page<>(pageParam.getPage(), pageParam.getPageSize(), pageParam.isSearchTotal());
        baseMapper.selectPage(page, queryWrapper);

        return PageResult.fromIPage(page, version -> new DocumentVersionDto().converterFrom(version));
    }
}
