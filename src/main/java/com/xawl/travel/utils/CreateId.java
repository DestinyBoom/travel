package com.xawl.travel.utils;

import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2017/11/21.
 */
public class CreateId {

    /**
     * Created on 2017/10/12.
     */
    /**
     * 生成商家ID
     *
     * @return
     */
    public static String gitId() {
        String time = "" + new Date().getTime();
        time = time.substring(time.length() - 8, time.length());
        Random ra = new Random();
        String code = time + ra.nextInt(10) + ra.nextInt(10);
        return code;
    }
}

