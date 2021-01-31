package com.cheirmin.tank;

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
    //坦克上下左右
    public static BufferedImage tankL,tankR,tankU,tankD;
    //子弹
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;

    static {
        try {
            tankL = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader()
                    .getResourceAsStream("static/images/tankL.gif")));
            tankR = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader()
                    .getResourceAsStream("static/images/tankR.gif")));
            tankU = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader()
                    .getResourceAsStream("static/images/tankU.gif")));
            tankD = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader()
                    .getResourceAsStream("static/images/tankD.gif")));

            bulletL = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader()
                    .getResourceAsStream("static/images/bulletL.gif")));
            bulletR = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader()
                    .getResourceAsStream("static/images/bulletR.gif")));
            bulletU = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader()
                    .getResourceAsStream("static/images/bulletU.gif")));
            bulletD = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader()
                    .getResourceAsStream("static/images/bulletD.gif")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
