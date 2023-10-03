package ex01;
public class Program {
    public static void main(String[] args) {
        User user1 = new User("Sasha", 500);
        User user2 = new User("Masha", 1000);
        User user3 = new User("Natasha", 0);
        User user4 = new User("Bobik", -200);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);
        System.out.println(UserIdsGenerator.getIdentifier());
        System.out.println(UserIdsGenerator.getIdentifier());
        System.out.println(UserIdsGenerator.getIdentifier());
        User user5 = new User("Tim", 100);
        System.out.println(UserIdsGenerator.getIdentifier());
        System.out.println(user5);
    }
}
