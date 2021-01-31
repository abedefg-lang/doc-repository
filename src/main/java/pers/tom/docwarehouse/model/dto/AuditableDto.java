package pers.tom.docwarehouse.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pers.tom.docwarehouse.model.entity.AuditableEntity;
import pers.tom.docwarehouse.model.supports.OutputData;
import pers.tom.docwarehouse.utils.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lijia
 * @description 可审计的dto对象
 * @date 2021-01-29 13:45
 */
@Data
public abstract class AuditableDto<T extends AuditableEntity> implements OutputData<T> {

    @ApiModelProperty("创建人名称")
    private String createBy;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("修改人名称")
    private String updateBy;

    @ApiModelProperty("修改时间")
    private String updateTime;

    @Override
    public void converterFrom(T t) {

        if(t != null){

            //获取秒级别的format
            SimpleDateFormat format = DateFormatUtils.getFormat(DateFormatUtils.SECOND_LEVEL_PATTERN);
            this.createTime = format.format(format.format(new Date(t.getCreateTime())));
            this.updateTime = format.format(format.format(new Date(t.getUpdateTime())));

            //通过用户id获取用户名
            this.createBy = t.getCreateBy();
            this.updateBy = t.getUpdateBy();

            //转换其余字段
            doConverter(t);
        }

    }

    /**
     * 转换其余字段
     * @param t entity对象
     */
    protected abstract void doConverter(T t);
}
