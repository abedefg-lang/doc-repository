package pers.tom.docwarehouse.model.dto.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pers.tom.docwarehouse.model.entity.base.AuditableEntity;
import pers.tom.docwarehouse.model.supports.OutputData;
import pers.tom.docwarehouse.utils.DateFormatUtils;

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
            String pattern = DateFormatUtils.SECOND_LEVEL_PATTERN;
            this.createTime = DateFormatUtils.parseTime(pattern, t.getCreateTime());
            this.updateTime = DateFormatUtils.parseTime(pattern, t.getUpdateTime());

            //通过用户id获取用户名
            this.createBy = t.getCreateBy();
            this.updateBy = t.getUpdateBy();

            //转换其余字段
            doConverter(t);
        }


    }

    /**
     * 转换其余字段
     * @param t t
     */
    protected abstract void doConverter(T t);
}
