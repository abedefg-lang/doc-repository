package pers.tom.docwarehouse.model.supports.converter;

/**
 * @author lijia
 * @description 输入数据
 * @date 2021-01-29 13:11
 */
public interface InputData<T> {

    /**
     * 将输入数据转换成指定对象
     * @return 返回对象
     */
    T converterTo();
}
