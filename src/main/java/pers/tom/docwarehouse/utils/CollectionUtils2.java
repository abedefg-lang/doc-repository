package pers.tom.docwarehouse.utils;


import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author tom
 * @description 集合工具类
 * @date 2021/2/1 0:28
 */
public class CollectionUtils2 {

    /**
     * 转换集合
     * @param source source集合
     * @param function 转换逻辑
     * @param <S> source
     * @param <T> target
     * @return 返回转换后的集合
     */
    public static <S, T> List<T> transform(Collection<S> source, Function<S, T> function){

        Assert.notNull(function, "function不能为null");
        if(CollectionUtils.isEmpty(source)){
            return Collections.emptyList();
        }

        return source.stream().map(function).collect(Collectors.toList());
    }

    /**
     * 判断一个集合是否为null 或者没有元素
     * @param collection 集合
     * @return 返回是否为空
     */
    public static boolean isEmpty(Collection<?> collection){
        return collection == null || collection.isEmpty();
    }

}
