package pers.tom.docwarehouse.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pers.tom.docwarehouse.model.entity.Module;

/**
 * @author tom
 * @description
 * @date 2021/1/30 16:30
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class ModuleDto extends AuditableDto<Module> {

    @ApiModelProperty("模块主键id")
    private Long moduleId;

    @ApiModelProperty("模块名称")
    private String name;

    @Override
    protected void doConverter(Module module) {
        this.moduleId = module.getModuleId();
        this.name = module.getName();
    }
}
