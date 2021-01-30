package com.cheirmin.tank.pojo;

import com.cheirmin.tank.Dir;
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
    private int wide, high;
    private Dir dir;
    private final int SPEED = 10;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
        dir = Dir.NO;
        wide = 50;
        high = 50;
    }

    public void paint(Graphics g) {
        //绘制一个矩形
        g.fillRect(x, y, wide, high);
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
}
