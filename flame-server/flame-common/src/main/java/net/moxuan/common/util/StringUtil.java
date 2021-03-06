package net.moxuan.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 判断字符是否为数字
     *
     * @param cs 要检查的字符串
     * @return boolean
     */
    public static boolean isNumber(CharSequence cs) {
        for (int i = 0; i < cs.length(); i++) {
            if (!Character.isDigit(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串转list，去掉内容为空的 例如a,,c 转换之后a,c
     *
     * @param cs 要转换的字符串
     * @param regex 分隔符
     * @return List<String>
     */
    public static List<String> stringToList(String cs, String regex) {
        String[] array = cs.split(regex);
        List<String> list = new ArrayList<>();
        for (int i = 0, len = array.length - 1; i <= len; i++) {
            if (!isEmpty(array[i])) {
                list.add(array[i]);
            }
        }
        return list;
    }
    /**
     * 字符串转list，去掉内容为空的 例如a,,c 转换之后a,c
     *
     * @param cs 要转换的字符串
     * @return List<String>
     */
    public static List<String> stringToList(String cs) {
        return stringToList(cs, ",");
    }

}
