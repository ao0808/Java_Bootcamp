package ex00;

public class Hen extends Thread{
    private int countHen;
    public Hen(int countIn){
        countHen = countIn;
    }

    public void run() {
        for (int i = 0; i < countHen; i++) {
            System.out.println("HEN");
        }
    }
}
