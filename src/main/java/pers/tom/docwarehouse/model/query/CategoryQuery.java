package pers.tom.docwarehouse.model.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.StringUtils;
import pers.tom.docwarehouse.model.entity.Category;
import pers.tom.docwarehouse.model.supports.auditable.AuditableQuery;

/**
 * @author tom
 * @description
 * @date 2021/2/3 22:55
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class CategoryQuery extends AuditableQuery<Category> {

    @ApiModelProperty("种类名称")
    private String name;

    @Override
    protected void fillConditions(QueryWrapper<Category> queryWrapper) {
        queryWrapper.likeRight(!StringUtils.isEmpty(name), "name", name);
    }
}
