package pers.tom.docwarehouse.model.supports.converter;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * @author tom
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
