package ex00.ImagesToChar.src.java.edu.school21.printer.app;

import ex00.ImagesToChar.src.java.edu.school21.printer.logic.PrintImage;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        if (args.length != 3){
            System.err.println("Invalid input");
            System.exit(-1);
        }
        char white = args[0].charAt(0);
        char black = args[1].charAt(0);
        String address = args[2];
        PrintImage prog = new PrintImage(white, black, address);
        prog.printMy();
    }
}
