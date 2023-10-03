package ex02.ImageToChar.src.java.edu.school21.printer.logic;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PrintImage {
    private String white;
    private String black;
    private BufferedImage image;
    // URL inputImage;

    public PrintImage(Args args1, String address) throws IOException {
        white = args1.getWhite();
        black = args1.getBlack();
        image = ImageIO.read(new File(address));
    }

    public void printMy() {
        ColoredPrinter printerColor = new ColoredPrinter();
        int width = image.getWidth();
        int height = image.getHeight();
        for (int i = 0; i < width; i++) {
            for (int k = 0; k < height; k++) {
                int pixel = image.getRGB(k, i);
                if (pixel == Color.WHITE.getRGB()) {
                    printerColor.print(" ", Ansi.Attribute.NONE, Ansi.FColor.NONE, Ansi.BColor.valueOf(white));
                } else {
                    printerColor.print(" ", Ansi.Attribute.NONE, Ansi.FColor.NONE, Ansi.BColor.valueOf(black));
                }
            }
            System.out.println();
        }
    }
}
