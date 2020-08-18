package net.moxuan.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: moxuan
 * @description: 自定义工具类
 */
public class StringUtil {

    /**
     * 判断字符是否为空 空格也算空
     *
     * @param cs 要检查的字符串
     * @return boolean
     */
    public static boolean isEmpty(CharSequence cs) {
        return StringUtils.isBlank(cs);
    }

}
