package pers.tom.docwarehouse.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.tom.docwarehouse.model.entity.Category;
import pers.tom.docwarehouse.model.supports.auditable.AuditableDto;

/**
 * @author tom
 * @description
 * @date 2021/2/3 22:52
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class CategoryDto extends AuditableDto<CategoryDto, Category> {

    @ApiModelProperty("主键")
    private Long categoryId;

    @ApiModelProperty("分类名称")
    private String name;

    @Override
    protected void doConverter(Category category) {
        this.categoryId = category.getCategoryId();
        this.name = category.getName();
    }
}
