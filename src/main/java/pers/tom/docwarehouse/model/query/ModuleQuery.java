package pers.tom.docwarehouse.model.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;
import pers.tom.docwarehouse.model.query.base.AuditableQuery;
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
public class ModuleQuery extends AuditableQuery<Module> {

    @ApiModelProperty("模块名称")
    private String name;

    @Override
    protected void fillConditions(QueryWrapper<Module> queryWrapper) {
        queryWrapper.likeRight(!StringUtils.isEmpty(name), "name", name);
    }
}
