package pers.tom.docwarehouse.service.supports;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.tom.docwarehouse.utils.CollectionUtils2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lijia
 * @description 可转换的service
 * @date 2021-02-01 9:49
 */
public interface ConvertibleService<OUT, T> extends IService<T> {

    /**
     * 将数据进行转换
     * @param t t
     * @return 返回输出数据
     */
    OUT convertTo(T t);

    /**
     * 批量转换
     * @param list list
     * @return 返回list
     */
    default List<OUT> converterList(List<T> list){
        if(CollectionUtils2.isEmpty(list)){
            return Collections.emptyList();
        }

        return list.stream().map(this::convertTo).collect(Collectors.toList());
    }
}
