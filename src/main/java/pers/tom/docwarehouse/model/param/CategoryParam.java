package pers.tom.docwarehouse.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pers.tom.docwarehouse.model.entity.Category;
import pers.tom.docwarehouse.model.supports.converter.InputData;

import javax.validation.constraints.NotBlank;

/**
 * @author tom
 * @description
 * @date 2021/2/3 22:56
 */
@Data
@ApiModel
public class CategoryParam implements InputData<Category> {

    @NotBlank
    @ApiModelProperty("分类名称")
    private String name;

    @Override
    public Category converterTo() {

        Category category = new Category();
        category.setName(name);
        return category;
    }
}
