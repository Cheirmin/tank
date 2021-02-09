package com.cheirmin.tank.interf;

import com.cheirmin.tank.ennum.Group;
import com.cheirmin.tank.pojo.Bullet;
import com.cheirmin.tank.pojo.Tank;
import com.cheirmin.tank.util.Audio;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: Cheirmin
 * @since: 2021-02-03
 * @history: 1.2021-02-03 created by Cheirmin
 */

public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.getX();
        int bY = t.getY();
        switch (t.getDir()) {
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

        if (t.getGroup() == Group.GOOD ){
            new Thread(()->new Audio("static/audio/tank_fire.wav"));
        }

        new Bullet(bX, bY, t.getDir(), t.getGroup(), t.getTf());
    }
}
