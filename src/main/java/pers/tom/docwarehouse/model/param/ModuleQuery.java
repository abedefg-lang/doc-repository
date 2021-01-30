package pers.tom.docwarehouse.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pers.tom.docwarehouse.model.entity.Module;

/**
 * @author tom
 * @description module查询对象
 * @date 2021/1/30 23:42
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class ModuleQuery extends AuditableQuery<Module>{

    @ApiModelProperty("模块名称")
    private String name;
}
