package com.eim.util;

import java.util.Random;

/**
 * Created by Zy on 2018/12/25.
 */
public class KeyUtil {
    /**
     * 获取唯一索引
     * @return 时间戳 + 5位随机数
     */
    public static synchronized String getUniKey(){
        long l = System.currentTimeMillis();
        Random random = new Random();
        int i = random.nextInt(90000) + 10000;
        return String.valueOf(l)+i;
    }
}
