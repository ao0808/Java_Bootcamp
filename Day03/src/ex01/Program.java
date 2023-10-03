package ex01;


public class Program {
    public static void main(String[] args) throws InterruptedException {
        int count;
        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.out.println("Wrong argument");
            System.exit(-1);
        }
        count = Integer.parseInt(args[0].substring("--count=".length()));
        if (count <= 0) {
            System.out.println("Invalid count: " + count);
            System.exit(-1);
        } else {
            Print print = new Print();
            Egg egg = new Egg(count, print);
            Hen hen = new Hen(count, print);
            egg.start();
            hen.start();
        }
    }
}
