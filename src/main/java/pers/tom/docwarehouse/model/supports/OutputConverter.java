package pers.tom.docwarehouse.model.supports;

/**
 * @author lijia
 * @description 输出转换器
 * @date 2021-01-29 13:12
 */
public interface OutputConverter<T> {

    /**
     * 将指定对象转换成输出对象
     * @param t 对象
     */
    void converterFrom(T t);
}
