package ex01;

public class User {
    private Integer Identifier;
    private String Name;
    private Integer Balance;

    public User(String name, Integer balance){
        Identifier = UserIdsGenerator.getInstance().generateId();
        Name = name;
        setBalance(balance);
    }

    public Integer getBalance() {
        return Balance;
    }

    public void setBalance(Integer balance) {
        if (balance < 0){
            System.err.println("Balance should be positive");
        } else {
            Balance = balance;
        }
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return "User{" +
                "Identifier= " + Identifier +
                ", Name= '" + Name + '\'' +
                ", Balance= " + Balance +
                '}';
    }
}
