package pers.tom.docwarehouse.service.supports;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.util.CollectionUtils;
import pers.tom.docwarehouse.model.supports.OutputData;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lijia
 * @description 对mybatis-plus的service进行扩展
 * @date 2021-01-31 18:13
 */
public interface BaseService<OUT extends OutputData<T>, T> extends IService<T> {

    /**
     * 将数据转换为输出数据
     * @param t 数据
     * @return 返回输出数据
     */
    OUT converterTo(T t);

    /**
     * 批量转换
     * @param list list
     * @return 返回list
     */
    default List<OUT> converterList(List<T> list){
        if(CollectionUtils.isEmpty(list)){
            return Collections.emptyList();
        }

        return list.stream().map(this::converterTo).collect(Collectors.toList());
    }
}
