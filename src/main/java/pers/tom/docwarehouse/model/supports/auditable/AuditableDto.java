package pers.tom.docwarehouse.model.supports.auditable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pers.tom.docwarehouse.model.supports.converter.OutputData;
import pers.tom.docwarehouse.utils.DateFormatUtils;

import java.text.SimpleDateFormat;

/**
 * @author lijia
 * @description 可审计的dto对象
 * @date 2021-01-29 13:45
 */
@Data
public abstract class AuditableDto<OUT, T extends AuditableEntity> implements OutputData<OUT, T> {

    @ApiModelProperty("创建人名称")
    private String createdBy;

    @ApiModelProperty("创建人id")
    private Long creatorId;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("修改人名称")
    private String updatedBy;

    @ApiModelProperty("修改人id")
    private Long updaterId;

    @ApiModelProperty("修改时间")
    private String updateTime;

    @Override
    public OUT converterFrom(T t) {

        if(t != null){

            this.createdBy = t.getCreatedBy();
            this.creatorId = t.getCreatorId();
            this.updatedBy = t.getUpdatedBy();
            this.updaterId = t.getUpdaterId();

            //格式化时间
            SimpleDateFormat format = DateFormatUtils.getFormat(DateFormatUtils.SECOND_LEVEL_PATTERN);
            this.createTime = format.format(t.getCreateTime());
            this.updateTime = format.format(t.getUpdateTime());

            //转换其余字段
            doConverter(t);
        }

        return (OUT) this;
    }

    /**
     * 转换其余字段
     * @param t t
     */
    protected abstract void doConverter(T t);
}
