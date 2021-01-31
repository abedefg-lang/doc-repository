package pers.tom.docwarehouse.model.supports;

/**
 * @author lijia
 * @description 输出数据
 * @date 2021-01-29 13:12
 */
public interface OutputData<T> {

    /**
     * 将指定对象转换成输出数据
     * @param t 对象
     */
    void converterFrom(T t);
}
