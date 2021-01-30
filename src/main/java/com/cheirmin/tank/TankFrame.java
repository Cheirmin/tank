package com.cheirmin.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    int x = 200, y = 200;

    public TankFrame() {
        //大小
        setSize(800, 600);
        //固定大小
        setResizable(false);
        //标题
        setTitle("坦克大战");
        //可见
        setVisible(true);

        this.addKeyListener(new MyKeyListener());

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
     *
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {
        //绘制一个矩形
        g.fillRect(x, y, 50, 50);
    }

    /**
     * 键盘监听类
     */
    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_LEFT:
                    x -= 10;
                    break;
                case KeyEvent.VK_UP:
                    y -= 10;
                    break;
                case KeyEvent.VK_RIGHT:
                    x += 10;
                    break;
                case KeyEvent.VK_DOWN:
                    y += 10;
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //按键松开
//            y += 30;
        }
    }
}
