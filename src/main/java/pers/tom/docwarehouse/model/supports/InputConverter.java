package pers.tom.docwarehouse.model.supports;

/**
 * @author lijia
 * @description 输入转换器
 * @date 2021-01-29 13:11
 */
public interface InputConverter<T> {

    /**
     * 转换成指定对象
     * @return 返回对象
     */
    T converterTo();
}
