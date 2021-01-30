package pers.tom.docwarehouse.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.tom.docwarehouse.model.entity.Module;
import pers.tom.docwarehouse.model.supports.InputConverter;

import javax.validation.constraints.NotBlank;

/**
 * @author tom
 * @description 新增模块参数对象
 * @date 2021/1/30 15:51
 */
@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleParam implements InputConverter<Module> {

    @ApiModelProperty("模块名称")
    @NotBlank
    private String name;

    @Override
    public Module converterTo() {
        Module module = new Module();
        module.setName(name);
        return module;
    }
}
