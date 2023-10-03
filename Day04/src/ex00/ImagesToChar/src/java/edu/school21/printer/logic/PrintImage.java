package ex00.ImagesToChar.src.java.edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PrintImage {
    private char white;
    private char black;
    private BufferedImage image;

    public PrintImage(char whiteIn, char blackIn, String inputImage) throws IOException {
        white = whiteIn;
        black = blackIn;
        image = ImageIO.read(new File(inputImage));
    }

    public void printMy(){
        int width = image.getWidth();
        int height = image.getHeight();
        for(int i = 0; i < width; i++){
            for(int k = 0; k < height; k++){
                int pixel = image.getRGB(k, i);
                if(pixel == Color.WHITE.getRGB()){
                    System.out.print(white);
                } else {
                    System.out.print(black);
                }
            }
            System.out.println();
        }
    }
}
