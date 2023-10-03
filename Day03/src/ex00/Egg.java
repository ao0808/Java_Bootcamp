package ex00;

public class Egg extends Thread {
    private int countEgg;
    public Egg(int countIn){
        countEgg = countIn;
    }

    public void run(){
        for (int i = 0; i < countEgg; i++) {
            System.out.println("EGG");
        }
    }

}
