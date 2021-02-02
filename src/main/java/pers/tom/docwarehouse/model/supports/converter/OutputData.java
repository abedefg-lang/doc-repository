package pers.tom.docwarehouse.model.supports.converter;

/**
 * @author lijia
 * @description 输出数据
 * @date 2021-01-29 13:12
 */
public interface OutputData<OUT, T> {

    /**
     * 将指定对象转换成输出数据
     * @param t target
     * @return 返回输出对象
     */
    OUT converterFrom(T t);

}
