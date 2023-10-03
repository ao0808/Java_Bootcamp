package ex03;
import java.util.UUID;

public class Program {
    public static void main(String[] args) {


        User user1 = new User("Sasha", 500);
        User user2 = new User("Masha", 1000);
        User user3 = new User("Natasha", 0);

        TransactionsLinkedList listOfTransactionUser1 = user1.getTransactionsList();

        Transaction tr1 = new Transaction(user1, user2, Transaction.Category.OUTCOME,-300);
        Transaction tr2 = new Transaction(user1, user2, Transaction.Category.OUTCOME,-500);
        Transaction tr3 = new Transaction(user1, user2, Transaction.Category.INCOME,300);
        Transaction tr4 = new Transaction(user1, user2, Transaction.Category.INCOME, 500);

        listOfTransactionUser1.addTransaction(tr1);
        System.out.println(listOfTransactionUser1.getNodeId());
        listOfTransactionUser1.addTransaction(tr2);
        listOfTransactionUser1.addTransaction(tr3);
        System.out.println(listOfTransactionUser1.getNodeId());

        System.out.println("Пользователь User1 осуществил " + user1.getTransactionsList().getSize() + " транзакции(й).");

        System.out.println("Удалили третью транзацию: ");
        listOfTransactionUser1.removeTransactionById(tr3.getIdentifier());


        System.out.println("Попытаемся удалить несуществующую транзакцию: ");
        try {
            listOfTransactionUser1.removeTransactionById(UUID.randomUUID());
        } catch (TransactionNotFoundException ex) {
            System.out.println(ex);
        }

        System.out.println("Переведем список в массив и выведем на печать: ");
        Transaction[] arrayOfTransaction = listOfTransactionUser1.toArray();

        for (Transaction item : arrayOfTransaction) {
            item.printTransferInfo();
        }


    }
}

