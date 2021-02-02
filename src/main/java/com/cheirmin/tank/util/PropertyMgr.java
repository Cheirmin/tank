package com.cheirmin.tank.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: Cheirmin
 * @since: 2021-02-02
 * @history: 1.2021-02-02 created by Cheirmin
 */

public class PropertyMgr {
    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config/.config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (props == null) {
            return null;
        }
        return props.get(key);
    }

    //int getInt(key)
    //getString(key)

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));
    }
}
