package com.cheirmin.tank.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * @Copyright:
 * @Description: 资源管理者
 * @author: Cheirmin
 * @since: 2021-01-31
 * @history: 1.2021-01-31 created by Cheirmin
 */

public class ResourceMgr {
    //坏坦克上下左右
    public static BufferedImage[] goodTank = new BufferedImage[4];
    //我方坦克上下左右
    public static BufferedImage[] badTank = new BufferedImage[4];
    //子弹
    public static BufferedImage[] bullet = new BufferedImage[4];
    //爆炸效果
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            //上右下左 顺序
            goodTank[0] = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader()
                    .getResourceAsStream("static/images/GoodTank1.png")));
            goodTank[1] = ImageUtil.rotateImage(goodTank[0], 90);
            goodTank[2] = ImageUtil.rotateImage(goodTank[0], 180);
            goodTank[3] = ImageUtil.rotateImage(goodTank[0], -90);

            badTank[0] = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader()
                    .getResourceAsStream("static/images/BadTank1.png")));
            badTank[1] = ImageUtil.rotateImage(badTank[0], 90);
            badTank[2] = ImageUtil.rotateImage(badTank[0], 180);
            badTank[3] = ImageUtil.rotateImage(badTank[0], -90);

            bullet[0] = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader()
                    .getResourceAsStream("static/images/bulletU.gif")));
            bullet[1] = ImageUtil.rotateImage(bullet[0], 90);
            bullet[2] = ImageUtil.rotateImage(bullet[0], 180);
            bullet[3] = ImageUtil.rotateImage(bullet[0], -90);


            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader()
                        .getResourceAsStream("static/images/e" + (i + 1) + ".gif")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
