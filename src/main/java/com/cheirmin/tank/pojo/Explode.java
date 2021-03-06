package com.cheirmin.tank.pojo;

import com.cheirmin.tank.util.Audio;
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
public class Explode {
    //长宽
    public static int WIDE = ResourceMgr.explodes[0].getWidth();
    public static int HIGH = ResourceMgr.explodes[0].getHeight();

    //坐标
    private int x, y;
    //画布引用
    private TankFrame tf;
    //爆炸步骤
    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        new Thread(()->new Audio("static/audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length) {
           tf.explodes.remove(this);
        }
    }
}
