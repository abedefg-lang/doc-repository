package pers.tom.docrepository.common.model.converter;

/**
 * @author lijia
 * @description 输出转换器
 * @date 2021-01-29 13:12
 */
public interface OutputConverter<T> {

    /**
     * 将实体对象转换成输出对象
     * @param t 实体对象
     */
    void fromEntity(T t);
}
