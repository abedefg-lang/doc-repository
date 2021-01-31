package pers.tom.docwarehouse.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.supports.OutputData;
import pers.tom.docwarehouse.utils.DateFormatUtils;

/**
 * @author lijia
 * @description 操作日志dto
 * @date 2021-01-31 14:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class OperationLogDto implements OutputData<OperationLog> {

    @ApiModelProperty("主键")
    private Long operationLogId;

    @ApiModelProperty("操作人用户名")
    private String operator;

    @ApiModelProperty("操作信息")
    private String info;

    @ApiModelProperty("操作类型")
    private String type;

    @ApiModelProperty("操作时间")
    private String operationTime;

    @Override
    public void converterFrom(OperationLog operationLog) {
        if(operationLog != null){
            this.operationLogId = operationLog.getOperationLogId();
            this.operator = operationLog.getOperator();
            this.info = operationLog.getInfo();
            this.type = operationLog.getType();
            this.operationTime = DateFormatUtils.parseTime(DateFormatUtils.SECOND_LEVEL_PATTERN, operationLog.getOperationTime());
        }
    }
}
