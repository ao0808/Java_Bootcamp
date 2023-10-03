package ex03;
import java.util.UUID;

public class Transaction {
    private UUID Identifier;
    private User Recipient;
    private User Sender;
    private Transaction.Category TransferCategory;
    private Integer TransferAmount;

    public enum Category {
        INCOME, OUTCOME
    }
    public Transaction(User recipient, User sender, Transaction.Category transferCategory, Integer transferAmount){
        if ((transferAmount > 0 && transferCategory == Transaction.Category.OUTCOME) ||
                (transferAmount < 0 && transferCategory == Transaction.Category.INCOME) ||
                (recipient.getBalance() < 0 || sender.getBalance() < 0)){
            System.err.println("Wrong transfer");
        } else if ((transferCategory ==Transaction.Category.INCOME && sender.getBalance() < transferAmount) ||
                (transferCategory == Transaction.Category.OUTCOME && sender.getBalance() < - transferAmount)){
            System.err.println("Insufficient " + sender.getName() + " balance");
        } else {
            Identifier = UUID.randomUUID();
            Recipient = recipient;
            Sender = sender;
            TransferCategory = transferCategory;
            TransferAmount = transferAmount;
        }
    }

    public UUID getIdentifier() {
        return Identifier;
    }
    public void printTransferInfo(){
        System.out.print("Sender: " + this.Sender.getName() + ". Recipient: " + this.Recipient.getName() );
        System.out.println(". Category: " + this.TransferCategory + ". Amount: " + this.TransferAmount);
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
