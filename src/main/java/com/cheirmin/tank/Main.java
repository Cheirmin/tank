package com.cheirmin.tank;

import com.cheirmin.tank.ennum.Dir;
import com.cheirmin.tank.ennum.Group;
import com.cheirmin.tank.pojo.Tank;
import com.cheirmin.tank.pojo.TankFrame;
import com.cheirmin.tank.util.Audio;
import com.cheirmin.tank.util.PropertyMgr;

import java.util.Objects;

/**
 * @Copyright:
 * @Description:
 * @author: Cheirmin
 * @since: 2021-01-30
 * @history: 1.2021-01-30 created by Cheirmin
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        int initTankCount = Integer.parseInt((String) Objects.requireNonNull(PropertyMgr.get("initTankCount")));

        //初始化地方坦克
        for (int i = 0; i < initTankCount; i++) {
            tf.tanks.add(new Tank(i * 80, 50,true, Dir.DOWN, Group.BAD, tf));
        }

        new Thread(()-> new Audio("static/audio/war1.wav").loop()).start();

        while (true) {
            //每隔50ms重绘画布
            Thread.sleep(50);
            tf.repaint();
        }
    }
}

