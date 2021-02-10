package pers.tom.docwarehouse.utils;

import pers.tom.docwarehouse.exception.ServiceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lijia
 * @description 日期格式化工具
 * @date 2021-01-29 13:51
 */
public class DateFormatUtils {

    /**天级别*/
    public static final String DAY_LEVEL_PATTERN = "yyyy-MM-dd";

    /**分级别*/
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

    /**
     * 将字符串解析成指定格式的日期
     * @param pattern pattern
     * @param source source
     * @return 返回date
     */
    public static Date parse(String pattern, String source){
        SimpleDateFormat format = getFormat(pattern);
        try{
            return format.parse(source);
        }catch (ParseException parseException){
            throw new ServiceException("日期不符合 [" + pattern + "] 格式");
        }
    }

    /**
     * 将日期格式化成指定格式
     * @param pattern pattern
     * @param date 日期
     * @return 返回字符串
     */
    public static String format(String pattern, Date date){
        SimpleDateFormat format = getFormat(pattern);
        return format.format(date);
    }

    /**
     * 获取指定日期格式字符串的毫秒值
     * @param pattern pattern
     * @param source source
     * @return 返回毫秒值
     */
    public static Long getTime(String pattern, String source){
        return parse(pattern, source).getTime();
    }

    /**
     * 将毫秒值解析为指定日期格式
     * @param pattern pattern
     * @param time time
     * @return 返回字符串
     */
    public static String parseTime(String pattern, Long time){
        return format(pattern, new Date(time));
    }



    static{

        //初始化将三个时间格式添加到缓存中
        FORMAT_CACHE.put(DAY_LEVEL_PATTERN, new SimpleDateFormat(DAY_LEVEL_PATTERN));
        FORMAT_CACHE.put(MINUTE_LEVEL_PATTERN, new SimpleDateFormat(MINUTE_LEVEL_PATTERN));
        FORMAT_CACHE.put(SECOND_LEVEL_PATTERN, new SimpleDateFormat(SECOND_LEVEL_PATTERN));
    }
}
