package com.cheirmin.tank;

import com.cheirmin.tank.pojo.Tank;

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

        //初始化地方坦克
        for (int i = 0; i < 5; i++) {
            tf.tanks.add(new Tank(i*186,50,Dir.DOWN,tf));
        }

        while (true) {
            //每隔50ms重绘画布
            Thread.sleep(50);
            tf.repaint();
        }
    }
}

