package com.cheirmin.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Copyright:
 * @Description:
 * @author: Cheirmin
 * @since: 2021-01-30
 * @history: 1.2021-01-30 created by Cheirmin
 */

public class Main {

    public static void main(String[] args) {
        Frame frame = new Frame();
        //大小
        frame.setSize(800,600);
        //固定大小
        frame.setResizable(false);
        //标题
        frame.setTitle("坦克大战");

        //可见
        frame.setVisible(true);

        //窗口可关闭
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

