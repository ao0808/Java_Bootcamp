package ex02.ImageToChar.src.java.edu.school21.printer.app;

import com.beust.jcommander.JCommander;
import ex02.ImageToChar.src.java.edu.school21.printer.logic.Args;
import ex02.ImageToChar.src.java.edu.school21.printer.logic.PrintImage;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        Args args1 = new Args();
        JCommander jCommander = new JCommander(args1);
        jCommander.parse(args);
        PrintImage prog = new PrintImage(args1, "/Users/aleksandrkurbatov/IdeaProjects/day04/src/ex02/ImageToChar/src/java/edu/school21/printer/resources/it.bmp");
        prog.printMy();
    }
}
