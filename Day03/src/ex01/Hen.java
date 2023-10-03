package ex01;

public class Hen extends Thread{
    private int count;
    private Print print;
    public Hen(int countIn, Print printIn){
        count = countIn;
        print = printIn;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            try {
                print.printHen();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
