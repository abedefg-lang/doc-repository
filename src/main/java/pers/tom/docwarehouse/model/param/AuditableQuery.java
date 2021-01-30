package pers.tom.docwarehouse.model.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.StringUtils;
import pers.tom.docwarehouse.model.entity.AuditableEntity;
import pers.tom.docwarehouse.model.supports.InputConverter;

import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author tom
 * @description 审记数据的查询对象
 * @date 2021/1/30 23:42
 */
@Data
public abstract class AuditableQuery<T extends AuditableEntity> implements InputConverter<QueryWrapper<T>> {

    @ApiModelProperty("创建人")
    private String createBy;

    @Past
    @ApiModelProperty("起始创建时间")
    private Date startCreateTime;

    @Future
    @ApiModelProperty("结束创建时间")
    private Date endCreateTime;

    @ApiModelProperty("修改人")
    private String updateBy;

    @Past
    @ApiModelProperty("起始修改时间")
    private Date startUpdateTime;

    @Future
    @ApiModelProperty("结束修改时间")
    private Date endUpdateTime;

    @Override
    public QueryWrapper<T> converterTo() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight(!StringUtils.isEmpty(createBy), "create_by", createBy);

        return queryWrapper;
    }
}
