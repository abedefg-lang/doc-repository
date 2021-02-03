package pers.tom.docwarehouse.model.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.StringUtils;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.supports.converter.QueryWrapperConverter;

/**
 * @author tom
 * @description 操作日志查询对象
 * @date 2021/2/3 22:28
 */
@Data
@ApiModel
public class OperationLogQuery implements QueryWrapperConverter<OperationLog> {

    @ApiModelProperty("日志信息")
    private String info;

    @ApiModelProperty("创建人id")
    private Long creatorId;

    @ApiModelProperty("起始创建时间")
    private String startCreateTime;

    @ApiModelProperty("结束创建时间")
    private String endCreateTime;

    @Override
    public QueryWrapper<OperationLog> toQueryWrapper() {

        QueryWrapper<OperationLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isEmpty(info), "info", info)
                .eq(creatorId != null, "creator_id", creatorId)
                .ge(StringUtils.isEmpty(startCreateTime), "create_time", startCreateTime)
                .le(StringUtils.isEmpty(endCreateTime), "create_time", endCreateTime);

        return queryWrapper;
    }
}
