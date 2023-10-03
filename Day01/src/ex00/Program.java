package ex00;

public class Program {
    public static void main(String[] args) {
        User User_1 = new User(1, "Sasha", 10000000);
        System.out.println(User_1);
        User User_2 = new User(1, "Alesha", 1000);
        System.out.println(User_2);
        Transaction First = new Transaction(User_1, User_2, Transaction.Category.OUTCOME, -500);
        Transaction Vest = new Transaction(User_1, User_2, Transaction.Category.INCOME, 500);
        System.out.println(First);
        System.out.println(Vest);
    }
}
