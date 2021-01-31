package com.cheirmin.tank.pojo;

import com.cheirmin.tank.Dir;
import com.cheirmin.tank.ResourceMgr;
import com.cheirmin.tank.TankFrame;
import lombok.Data;

import java.awt.*;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: Cheirmin
 * @since: 2021-01-30
 * @history: 1.2021-01-30 created by Cheirmin
 */
@Data
public class Bullet {
    private static final int SPEED = 20;

    public static int DWIDE = ResourceMgr.bulletD.getWidth();
    public static int DHIGH = ResourceMgr.bulletD.getHeight();

    public static int LWIDE = ResourceMgr.bulletL.getWidth();
    public static int LHIGH = ResourceMgr.bulletL.getHeight();

    private int x, y;
    private Dir dir;
    public boolean live = true;

    private TankFrame tf;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.bulletList.remove(this);
        }
        //绘制一个矩形
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }
}
