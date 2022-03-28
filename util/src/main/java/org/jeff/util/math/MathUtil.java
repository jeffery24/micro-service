package org.jeff.util.math;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author jeff
 * @since 1.0.0
 */
public class MathUtil {

    /**
     * 生成随机数
     * 加密算法:
     *  1. NativePRNG
     *  2. SHA1PRNG
     *
     * @param len 长度
     * @param interval 0-Interval
     * @return string random number
     */
    public static String randomNumber(int len,int interval) throws NoSuchAlgorithmException {

        String randomNumberStr = "";
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

        for (int i = 0; i < len; i++) {
            // 随机整数
            randomNumberStr =  randomNumberStr.concat(String.valueOf(random.nextInt(interval)));
        }

        return randomNumberStr;
    }
}
