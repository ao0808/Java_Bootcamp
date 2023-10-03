package ex01;

public class Egg extends Thread {
    private int count;
    private Print print;

    public Egg(int countIn, Print printIn) {
        count = countIn;
        print = printIn;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            try {
                print.printEgg();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}