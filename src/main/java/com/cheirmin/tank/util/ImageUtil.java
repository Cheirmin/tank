package com.cheirmin.tank.util;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Copyright:
 * @Description: 图片旋转工具类
 * @author: Cheirmin
 * @since: 2021-01-31
 * @history: 1.2021-01-31 created by Cheirmin
 */

public class ImageUtil {
    public static BufferedImage rotateImage(final BufferedImage bufferedimage,
                                            final int degree) {
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();
        return img;
    }

}
