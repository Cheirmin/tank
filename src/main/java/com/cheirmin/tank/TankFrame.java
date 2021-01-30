package com.cheirmin.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: Cheirmin
 * @since: 2021-01-30
 * @history: 1.2021-01-30 created by Cheirmin
 */

public class TankFrame extends Frame {
    public TankFrame() {
        //大小
        setSize(800,600);
        //固定大小
        setResizable(false);
        //标题
        setTitle("坦克大战");

        //可见
        setVisible(true);

        //窗口可关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 窗口绘制的时候，会调用这个
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g){
        //绘制一个矩形
        g.fillRect(200,200,50,50);
    }
}
