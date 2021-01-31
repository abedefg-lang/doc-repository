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
public abstract class AuditableDto<T, S extends AuditableEntity> implements OutputData<T, S> {

    @ApiModelProperty("创建人名称")
    private String createBy;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("修改人名称")
    private String updateBy;

    @ApiModelProperty("修改时间")
    private String updateTime;

    @Override
    public T converterFrom(S s) {

        if(s != null){

            //获取秒级别的format
            SimpleDateFormat format = DateFormatUtils.getFormat(DateFormatUtils.SECOND_LEVEL_PATTERN);
            this.createTime = format.format(format.format(new Date(s.getCreateTime())));
            this.updateTime = format.format(format.format(new Date(s.getUpdateTime())));

            //通过用户id获取用户名
            this.createBy = s.getCreateBy();
            this.updateBy = s.getUpdateBy();

            //转换其余字段
            doConverter(s);
        }

        return (T) this;

    }

    /**
     * 转换其余字段
     * @param s source
     */
    protected abstract void doConverter(S s);
}
