package com.cheirmin.tank;

import com.cheirmin.tank.pojo.Bullet;
import com.cheirmin.tank.pojo.Tank;

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
    Tank tank = new Tank(200, 200);
    Bullet bullet = new Bullet(tank.getX()+20,tank.getY()+20,tank.getDir());
    //画布大小
    static final int GAME_WIDTH = 800,GAME_HEIGHT = 600;

    public TankFrame() {
        //大小
        setSize(GAME_WIDTH, GAME_HEIGHT);
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

    //内存画图解决闪烁问题
    Image offScreenImage = null;
    @Override
    public void update(Graphics g){
        if (offScreenImage ==null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    /**
     * 窗口绘制的时候，会调用这个
     *
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {
        tank.paint(g);
        bullet.paint(g);
    }

    /**
     * 键盘监听类
     */
    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;

                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bL && !bR && !bU && !bD) {
                tank.setMoving(false);
                return;
            }

            tank.setMoving(true);
            if (bL) {

                tank.setDir(Dir.LEFT);
            }
            if (bR) {
                tank.setDir(Dir.RIGHT);
            }
            if (bU) {
                tank.setDir(Dir.UP);
            }
            if (bD) {
                tank.setDir(Dir.DOWN);
            }
        }
    }
}
