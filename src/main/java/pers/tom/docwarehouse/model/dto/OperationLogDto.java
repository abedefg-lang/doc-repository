package pers.tom.docwarehouse.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pers.tom.docwarehouse.model.entity.OperationLog;
import pers.tom.docwarehouse.model.supports.converter.OutputData;
import pers.tom.docwarehouse.utils.DateFormatUtils;

/**
 * @author tom
 * @description 操作日志dto
 * @date 2021/2/3 22:20
 */
@Data
@ApiModel
public class OperationLogDto implements OutputData<OperationLogDto, OperationLog> {

    @ApiModelProperty("主键")
    private Long operationLogId;

    @ApiModelProperty("操作信息")
    private String info;

    @ApiModelProperty("操作人")
    private String createdBy;

    @ApiModelProperty("操作人id")
    private Long creatorId;

    @ApiModelProperty("创建时间")
    private String createTime;

    @Override
    public OperationLogDto converterFrom(OperationLog operationLog) {
        if(operationLog != null){
            this.operationLogId = operationLog.getOperationLogId();
            this.info = operationLog.getInfo();
            this.createdBy = operationLog.getCreatedBy();
            this.creatorId = operationLog.getCreatorId();
            this.createTime = DateFormatUtils.format(DateFormatUtils.SECOND_LEVEL_PATTERN, operationLog.getCreateTime());
        }
        return this;
    }
}
