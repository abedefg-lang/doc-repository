package pers.tom.docwarehouse.model.supports;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * @author lijia
 * @description query wrapper 转换器
 * @date 2021-02-01 10:07
 */
public interface QueryWrapperConverter<T> {

    /**
     * 将数据转换成query wrapper
     * @return 返回query wrapper
     */
    QueryWrapper<T> toQueryWrapper();
}
