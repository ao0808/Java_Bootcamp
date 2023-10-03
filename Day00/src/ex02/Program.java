package ex02;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        int sum_number = 0;
        int tmp = 0;
        int tmp_res_all = 0;
        int count = 0;
        while (tmp != 42) {
            tmp = number.nextInt();
            tmp_res_all = sum_number_all(tmp);
            if(check_natural(tmp_res_all)){
                count++;
            }
        }
        number.close();
        System.out.println("Count of coffee-request " + count);
    }
    public static int sum_number_all(int tmp_in){
        int sum_number = 0;
        while (tmp_in != 0) {
            sum_number += tmp_in % 10;
            tmp_in = tmp_in / 10;
        }
        return sum_number;
    }

    public static boolean check_natural(int tmp_in){
        boolean bool = false;
        if (tmp_in <= 1) {
            System.err.print("Illegal Argument");
            System.exit(-1);
        } else {
            int i = 2;
            for (; i * i <= tmp_in; i++) {
                if (tmp_in % i == 0)
                    break;
            }
            bool = i * i > tmp_in;
        }
        return bool;
    }
}
