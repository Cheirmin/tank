import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: Cheirmin
 * @since: 2021-01-31
 * @history: 1.2021-01-31 created by Cheirmin
 */

public class ImageTest {
    @Test
    void test() {
        try {
            BufferedImage image = ImageIO.read(
                    new File("src/main/resources/static/images/0.gif"));
            assertNotNull(image);

            BufferedImage image2 = ImageIO.read(Objects.requireNonNull(ImageTest.class.getClassLoader()
                    .getResourceAsStream("static/images/0.gif")));
            assertNotNull(image2);

        } catch (IOException e) {
            e.printStackTrace();
        }

//        fail("Not yet impl");
//        assertNotNull(null);
    }

}
