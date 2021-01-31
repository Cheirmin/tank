package com.cheirmin.tank.pojo;

import com.cheirmin.tank.ennum.Dir;
import com.cheirmin.tank.ennum.Group;
import com.cheirmin.tank.util.ResourceMgr;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @Copyright:
 * @Description:
 * @author: Cheirmin
 * @since: 2021-01-30
 * @history: 1.2021-01-30 created by Cheirmin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tank {
    //存活
    public boolean live = true;
    //速度
    private static final int SPEED = 8;
    //坐标
    private int x, y;
    //是否移动
    private boolean moving = false;
    //方向
    private Dir dir;
    //阵营
    private Group group = Group.BAD;

    //长宽
    public static int DWIDE = ResourceMgr.badTank[0].getWidth();
    public static int DHIGH = ResourceMgr.badTank[0].getHeight();
    public static int LWIDE = ResourceMgr.badTank[1].getWidth();
    public static int LHIGH = ResourceMgr.badTank[1].getHeight();

    //随机数
    private Random random = new Random();
    //画布引用
    private TankFrame tf = null;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("子弹数 " + tf.bulletList.size(), 10, 45);
        g.drawString("敌人数 " + tf.tanks.size(), 100, 45);

        BufferedImage[] tank = (group == Group.BAD)
                ? ResourceMgr.badTank
                : ResourceMgr.goodTank;
        //绘制一个矩形
        switch (dir) {
            case LEFT:
                g.drawImage(tank[3], x, y, null);
                break;
            case RIGHT:
                g.drawImage(tank[1], x, y, null);
                break;
            case UP:
                g.drawImage(tank[0], x, y, null);
                break;
            case DOWN:
                g.drawImage(tank[2], x, y, null);
                break;
            default:
                break;
        }
        if (group == Group.BAD && random.nextInt(10) > 8) {
            this.fire();
        }

        move();
    }

    private void move() {
        if (!moving) {
            return;
        }
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
        //改变方向
//        randomDir();
    }

    public void fire() {
        if (!live) {
            return;
        }
        int bX = this.x;
        int bY = this.y;
        switch (dir) {
            case LEFT:
            case RIGHT:
                bX += (Tank.LWIDE - Bullet.LWIDE) / 2;
                bY += (Tank.LHIGH - Bullet.LHIGH) / 2;
                break;
            case UP:
            case DOWN:
                bX += (Tank.DWIDE - Bullet.DWIDE) / 2;
                bY += (Tank.DHIGH - Bullet.DHIGH) / 2;
                break;
            default:
                break;
        }

        tf.bulletList.add(new Bullet(bX, bY, this.dir, this.group, this.tf));
    }

    public void die() {
        this.live = false;
    }
}
