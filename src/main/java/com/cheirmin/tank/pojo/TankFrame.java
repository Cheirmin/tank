package com.cheirmin.tank.pojo;

import com.cheirmin.tank.ennum.Dir;
import com.cheirmin.tank.ennum.Group;
import com.cheirmin.tank.util.PropertyMgr;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @Copyright:
 * @Description:
 * @author: Cheirmin
 * @since: 2021-01-30
 * @history: 1.2021-01-30 created by Cheirmin
 */

public class TankFrame extends Frame {
    public Tank myTank = new Tank(370, 500,false, Dir.UP, Group.GOOD, this);
    public List<Bullet> bullets = new ArrayList<>();
    public List<Tank> tanks = new ArrayList<>();
    public List<Explode> explodes = new ArrayList<>();

    //画布大小
    public static final int GAME_WIDTH = Integer.parseInt((String) Objects.requireNonNull(PropertyMgr.get("gameWidth")));
    public static final int GAME_HEIGHT = Integer.parseInt((String) Objects.requireNonNull(PropertyMgr.get("gameHeight")));

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
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * 窗口绘制的时候，会调用这个
     *
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        //画爆炸
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }
        //画敌方坦克
        for (Iterator<Tank> it = tanks.iterator(); it.hasNext(); ) {
            Tank i = it.next();
            if (!i.live) {
                it.remove();
            }
            i.paint(g);
        }

        for (Bullet bullet : bullets) {
            for (Tank tank : tanks) {
                bullet.collideWith(tank);
            }
        }

        //我方坦克
        myTank.paint(g);
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
                case KeyEvent.VK_SPACE:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bL && !bR && !bU && !bD) {
                myTank.setMoving(false);
                return;
            }

            myTank.setMoving(true);
            if (bL) {
                myTank.setDir(Dir.LEFT);
            }
            if (bR) {
                myTank.setDir(Dir.RIGHT);
            }
            if (bU) {
                myTank.setDir(Dir.UP);
            }
            if (bD) {
                myTank.setDir(Dir.DOWN);
            }
        }
    }
}
