package ex03;

import ex02.UserIdsGenerator;

public class User {
    private TransactionsLinkedList transactionsList;
    private Integer Identifier;
    private String Name;
    private Integer Balance;

    public User(String name, Integer balance) {
        setBalance(balance);
        this.Name = name;
        this.Identifier = UserIdsGenerator.getInstance().generateId();
        transactionsList = new TransactionsLinkedList();
    }

    public void setBalance(Integer balance) {
        if(balance > 0) {
            this.Balance = balance;
        } else {
            System.err.println("Balance should be positive");
            this.Balance = 0;
        }
    }

    public Integer getId() {
        return Identifier;
    }

    public String getName() {
        return Name;
    }

    public Integer getBalance() {
        return Balance;
    }

    public TransactionsLinkedList getTransactionsList() {
        return transactionsList;
    }

    @Override
    public String toString() {
        return "ID: " + this.Identifier + "   Name: " + this.Name + "   Balance: " + this.Balance;
    }
}
