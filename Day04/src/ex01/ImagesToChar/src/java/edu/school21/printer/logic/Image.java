package ex01.ImagesToChar.src.java.edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

public class Image {
    private char white;
    private char black;
    private BufferedImage image;

    public Image(char white, char black, String filePath) throws IOException {
        this.white = white;
        this.black = black;
        image = ImageIO.read(Image.class.getResource(filePath));
    }

    public void print() {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                if(pixel == Color.WHITE.getRGB()) {
                    System.out.print(white);
                } else if(pixel == Color.BLACK.getRGB()) {
                    System.out.print(black);
                }
            }
            System.out.println();
        }
    }
}
