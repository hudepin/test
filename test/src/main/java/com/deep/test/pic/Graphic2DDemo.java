package com.deep.test.pic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName Graphic2DDemo
 * @create_date 2021.09.10 13:53
 * @since
 */
public class Graphic2DDemo {
    /**
     * 画一个圆形
     * @param args
     */
    public static void main(String[] args) {
        int windth=200,height=200;
        //创建图片对象
        BufferedImage image = new BufferedImage(windth,height,BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D graphics = image.createGraphics();
        //绘制逻辑开始
        graphics.setColor(Color.BLUE);
        Ellipse2D.Double eclipse = new Ellipse2D.Double(20,20,100,100);
        graphics.draw(eclipse);
        graphics.dispose();
        try {
            ImageIO.write(image,"png",new File("hudepin.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
