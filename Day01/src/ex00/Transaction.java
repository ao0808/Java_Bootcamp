package ex00;
import java.util.UUID;
public class Transaction {
    private UUID Identifier;
    private User Recipient;
    private User Sender;
    private Category TransferCategory;
    private Integer TransferAmount;

    public enum Category {
        INCOME, OUTCOME
    }
    public Transaction(User recipient, User sender, Category transferCategory, Integer transferAmount){
        if ((transferAmount > 0 && transferCategory == Category.OUTCOME) ||
                (transferAmount < 0 && transferCategory == Category.INCOME) ||
                (recipient.getBalance() < 0 || sender.getBalance() < 0)){
            System.err.println("Wrong transfer");
        } else if ((transferCategory == Category.INCOME && sender.getBalance() < transferAmount) ||
                (transferCategory == Category.OUTCOME && sender.getBalance() < - transferAmount)){
            System.err.println("Insufficient " + sender.getName() + " balance");
        } else {
            Identifier = UUID.randomUUID();
            Recipient = recipient;
            Sender = sender;
            TransferCategory = transferCategory;
            TransferAmount = transferAmount;
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "Identifier=" + Identifier +
                ", Recipient=" + Recipient +
                ", Sender=" + Sender +
                ", TransferCategory=" + TransferCategory +
                ", TransferAmount=" + TransferAmount +
                '}';
    }
}
