package com.cheirmin.tank;

/**
 * @Copyright:
 * @Description:
 * @author: Cheirmin
 * @since: 2021-01-30
 * @history: 1.2021-01-30 created by Cheirmin
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame frame = new TankFrame();
        while (true) {
            //每隔50ms重绘画布
            Thread.sleep(50);
            frame.repaint();
        }
    }
}

