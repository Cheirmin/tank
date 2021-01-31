package com.cheirmin.tank.pojo;

import com.cheirmin.tank.ennum.Dir;
import com.cheirmin.tank.ennum.Group;
import com.cheirmin.tank.util.ResourceMgr;
import lombok.Data;

import java.awt.*;

/**
 * @Copyright:
 * @Description:
 * @author: Cheirmin
 * @since: 2021-01-30
 * @history: 1.2021-01-30 created by Cheirmin
 */
@Data
public class Bullet {
    //速度
    private static final int SPEED = 20;
    //阵营
    private Group group;
    //长宽
    public static int DWIDE = ResourceMgr.bullet[0].getWidth();
    public static int DHIGH = ResourceMgr.bullet[0].getHeight();
    public static int LWIDE = ResourceMgr.bullet[1].getWidth();
    public static int LHIGH = ResourceMgr.bullet[1].getHeight();
    //坐标
    private int x, y;
    //方向
    private Dir dir;
    //存活
    public boolean live = true;
    //画布引用
    private TankFrame tf;

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.bullets.remove(this);
        }
        //绘制一个矩形
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bullet[3], x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bullet[1], x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bullet[0], x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bullet[2], x, y, null);
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

    /**
     * 碰撞处理
     *
     * @param tank 坦克
     */
    public void collideWith(Tank tank) {
        //如果是己方坦克的子弹，不会死亡
        if (this.group == tank.getGroup()) {
            return;
        }

        Rectangle rect1;
        Rectangle rect2;
        switch (dir) {
            case LEFT:
            case RIGHT:
                rect1 = new Rectangle(this.x, this.y, LWIDE, LHIGH);
                break;
            case UP:
            case DOWN:
                rect1 = new Rectangle(this.x, this.y, DWIDE, DHIGH);
                break;
            default:
                rect1 = new Rectangle();
                break;
        }

        switch (tank.getDir()) {
            case LEFT:
            case RIGHT:
                rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.LWIDE, Tank.LHIGH);
                break;
            case UP:
            case DOWN:
                rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.DWIDE, Tank.DHIGH);
                break;
            default:
                rect2 = new Rectangle();
                break;
        }

        if (rect2.intersects(rect1)) {
            tank.die();
            this.die();
            tf.explodes.add(new Explode(this.x, this.y, tf));
        }
    }

    private void die() {
        this.live = false;
    }
}
