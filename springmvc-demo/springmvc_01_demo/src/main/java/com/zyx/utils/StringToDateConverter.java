package com.zyx.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * 描述：把字符串转换日期
 * </pre>
 *
 * @author zhengyx
 * @email zhengyx@gillion.com.cn
 * @date 2020/9/15
 * @time 18:11
 * @description: 把字符串转换日期
 */

public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        // 判断
        if(source == null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // 把字符串转换日期
            return df.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出现错误");
        }

    }
}
