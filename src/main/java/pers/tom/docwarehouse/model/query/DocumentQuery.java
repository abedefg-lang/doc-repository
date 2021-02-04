package pers.tom.docwarehouse.model.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.StringUtils;
import pers.tom.docwarehouse.model.entity.Document;
import pers.tom.docwarehouse.model.supports.auditable.AuditableQuery;

/**
 * @author lijia
 * @description
 * @date 2021-02-04 11:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class DocumentQuery extends AuditableQuery<Document> {

    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("文档标题")
    private String title;

    @ApiModelProperty("文档概述")
    private String contentOverview;

    @Override
    protected void fillConditions(QueryWrapper<Document> queryWrapper) {
        queryWrapper.eq(categoryId != null, "category_id", categoryId)
                .likeRight(!StringUtils.isEmpty(title), "title", title)
                .like(!StringUtils.isEmpty(contentOverview), "content_overview", contentOverview)
                .orderByDesc("create_time");
    }
}
