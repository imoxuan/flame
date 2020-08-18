package net.moxuan.util;

import net.moxuan.exception.CheckException;

/**
 * @author: moxuan
 * @description:
 */
public class CheckUtil {

    public static void notEmpty(String str, String code, String message) {
        if (StringUtil.isEmpty(str)) {
            fail(code, message);
        }
    }

    public static void notExits(int count, String code, String message) {
        if (count > 0) {
            fail(code, message);
        }
    }

    private static void fail(String code, String message) {
        throw new CheckException(code, message);
    }
}
