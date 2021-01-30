package com.cheirmin.tank.pojo;

import com.cheirmin.tank.Dir;
import com.cheirmin.tank.TankFrame;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
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
    //坐标
    private int x, y;
    private boolean moving = false;
    private Dir dir;

    //长宽
    private static final int WIDE = 50, HIGH = 50;
    private static final int SPEED = 5;

    private TankFrame tf = null;

    public Tank(int x, int y,Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("子弹数量"+tf.bulletList.size(),10,60);
        //绘制一个矩形
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, WIDE, HIGH);
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
        tf.bulletList.add(new Bullet(this.x,this.y,this.dir,tf));
    }
}
