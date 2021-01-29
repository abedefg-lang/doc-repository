package pers.tom.docrepository.common.utils;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lijia
 * @description 获取日期格式化工具
 * @date 2021-01-29 13:51
 */
public class SimpleDataFormatUtils {

    /**天级别*/
    public static final String DAY_LEVEL_PATTERN = "yyyy-MM-dd";

    /**分级别级别*/
    public static final String MINUTE_LEVEL_PATTERN = "yyyy-MM-dd HH:mm";

    /**秒级别*/
    public static final String SECOND_LEVEL_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**format 缓存  key是时间格式*/
    private static final Map<String, SimpleDateFormat> FORMAT_CACHE = new HashMap<>(8);


    /**
     * 获取format
     * 先看缓存中有没有，如果没有进行创建然后放到缓存中
     * @param pattern 日期搁置
     * @return 返回format
     */
    public static SimpleDateFormat getFormat(String pattern){
        SimpleDateFormat format = FORMAT_CACHE.get(pattern);
        if(format == null){
            format = new SimpleDateFormat(pattern);
            FORMAT_CACHE.put(pattern, format);
        }
        return format;
    }


    static{

        //初始化将三个时间格式添加到缓存中
        FORMAT_CACHE.put(DAY_LEVEL_PATTERN, new SimpleDateFormat(DAY_LEVEL_PATTERN));
        FORMAT_CACHE.put(MINUTE_LEVEL_PATTERN, new SimpleDateFormat(MINUTE_LEVEL_PATTERN));
        FORMAT_CACHE.put(SECOND_LEVEL_PATTERN, new SimpleDateFormat(SECOND_LEVEL_PATTERN));
    }
}
