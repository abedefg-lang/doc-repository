package pers.tom.docwarehouse.model.supports.auditable;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.StringUtils;
import pers.tom.docwarehouse.model.supports.converter.QueryWrapperConverter;

/**
 * @author tom
 * @description 审记数据的查询对象
 * @date 2021/1/30 23:42
 */
@Data
public abstract class AuditableQuery<T extends AuditableEntity> implements QueryWrapperConverter<T> {

    @ApiModelProperty("创建人id")
    private Long creatorId;

    @ApiModelProperty("起始创建时间")
    private String startCreateTime;

    @ApiModelProperty("结束创建时间")
    private String endCreateTime;

    @ApiModelProperty("修改人id")
    private Long updaterId;

    @ApiModelProperty("起始修改时间")
    private String startUpdateTime;

    @ApiModelProperty("结束修改时间")
    private String endUpdateTime;

    @Override
    public QueryWrapper<T> toQueryWrapper(){

        //创建查询条件
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(creatorId != null, "creator_id", creatorId)
                .ge(!StringUtils.isEmpty(startCreateTime), "create_time", startCreateTime)
                .le(!StringUtils.isEmpty(endCreateTime), "create_time", endCreateTime)
                .eq(updaterId != null, "updater_id", updaterId)
                .ge(!StringUtils.isEmpty(startUpdateTime), "update_time", startUpdateTime)
                .le(!StringUtils.isEmpty(endUpdateTime), "update_time", endUpdateTime)
                .orderByDesc("create_time");

        this.fillConditions(queryWrapper);

        return queryWrapper;
    }

    /**
     * 交给子类填充条件
     * @param queryWrapper 查询条件
     */
    protected abstract void fillConditions(QueryWrapper<T> queryWrapper);
}
