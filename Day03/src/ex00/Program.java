package ex00;

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
            Egg egg = new Egg(count);
            Hen hen = new Hen(count);
            egg.start();
            hen.start();
            egg.join();
            hen.join();
            for(int i = 0; i < count; i++){
                System.out.println("Human");
            }
        }
    }
}
