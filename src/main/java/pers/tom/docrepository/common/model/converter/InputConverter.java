package pers.tom.docrepository.common.model.converter;

/**
 * @author lijia
 * @description 输入转换器
 * @date 2021-01-29 13:11
 */
public interface InputConverter<T> {

    /**
     * 转换成指定实体类类型
     * @return 返回实体对象
     */
    T toEntity();
}
