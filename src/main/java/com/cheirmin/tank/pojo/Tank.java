package com.cheirmin.tank.pojo;

import com.cheirmin.tank.Dir;
import com.cheirmin.tank.ResourceMgr;
import com.cheirmin.tank.TankFrame;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

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
    public boolean live = true;
    //坐标
    private int x, y;
    //是否移动
    private boolean moving = false;
    //方向
    private Dir dir;
    //长宽
    public static int DWIDE = ResourceMgr.tankD.getWidth();
    public static int DHIGH = ResourceMgr.tankD.getHeight();
    public static int LWIDE = ResourceMgr.tankL.getWidth();
    public static int LHIGH = ResourceMgr.tankL.getHeight();

    //速度
    private static final int SPEED = 5;
    //画布引用
    private TankFrame tf = null;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("子弹数量" + tf.bulletList.size(), 10, 50);
        //绘制一个矩形
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
            default:
                break;
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
    }

    public void fire() {
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

        tf.bulletList.add(new Bullet(bX, bY, this.dir, this.tf));
    }
}
