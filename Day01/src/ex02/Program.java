package ex02;
public class Program {
    public static void main(String[] args) {
        User user1 = new User("Sasha", 500);
        User user2 = new User("Masha", 1000);
        User user3 = new User("Natasha", 0);
        UsersArrayList userList = new UsersArrayList();
        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        System.out.println(userList);
    }
//    UsersArrayList userList = new UsersArrayList();

//    userList.addUser(user1);
}
