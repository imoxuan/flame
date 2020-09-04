package net.moxuan.common.util;

import net.moxuan.common.exception.CheckException;

/**
 * @author: moxuan
 * @description:
 */
public class CheckUtil {

    public static void notExits(int count, int code, String message) {
        if (count > 0) {
            fail(code, message);
        }
    }

    private static void fail(int code, String message) {
        throw new CheckException(code, message);
    }
}
