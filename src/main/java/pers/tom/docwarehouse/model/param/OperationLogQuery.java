package pers.tom.docwarehouse.model.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.supports.InputData;
import pers.tom.docwarehouse.utils.DateFormatUtils;

/**
 * @author lijia
 * @description
 * @date 2021-01-31 17:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class OperationLogQuery implements InputData<QueryWrapper<OperationLog>> {

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("info")
    private String info;

    @ApiModelProperty("操作人")
    private String operator;

    @ApiModelProperty("起始操作时间")
    private String startTime;

    @ApiModelProperty("结束操作时间")
    private String endTime;

    @Override
    public QueryWrapper<OperationLog> converterTo() {

        String pattern = DateFormatUtils.SECOND_LEVEL_PATTERN;
        QueryWrapper<OperationLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight(!StringUtils.isEmpty(type), "type", type)
                .like(!StringUtils.isEmpty(info), "info", info)
                .likeRight(!StringUtils.isEmpty(operator), "operator", operator)
                .ge(!StringUtils.isEmpty(startTime), "operation_time", DateFormatUtils.getTime(pattern, startTime))
                .le(!StringUtils.isEmpty(endTime), "operation_time", DateFormatUtils.getTime(pattern, endTime));

        return queryWrapper;
    }
}
