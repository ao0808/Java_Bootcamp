package ex03;
import java.util.Scanner;
import java.util.LinkedList;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String stmp = "";
        int grade1 = 0;
        int grade2 = 10;
        int count = 0;
        LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
        while (!(stmp = scan.nextLine()).equals("42") && count < 18){
            count++;
            if (!stmp.equals("Week " + count)){
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            for (int i = 0; i < 4; i++) {
                grade1 = scan.nextInt();
                if(check(grade1)){
                    if (grade1 < grade2) {
                        grade2 = grade1;
                    }
                } else {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
            }
            myLinkedList.add(grade2);
            scan.nextLine();
            grade2 = 10;
        }
        print(count, myLinkedList);
        scan.close();
    }
    public static boolean check(int grad){
        boolean res = true;
        if (grad < 1 || grad > 9){
            res = false;
        }
        return res;
    }

    public static void print(int count, LinkedList<Integer> myLinkedList){
        for (int i = 0; i < count; i++){
            System.out.println("week " + (i + 1));
            for (int j = 0; j < myLinkedList.get(i); j++){
                System.out.print("=");
            }
            System.out.println(">");
        }
    }
}
