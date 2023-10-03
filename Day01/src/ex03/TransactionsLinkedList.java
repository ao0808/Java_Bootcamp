package ex03;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList{
    private Node first;
    private Node last;
    private Integer sizeList;
    public static class Node {
        Node prev;
        Node next;
        Transaction trans;

        public Node(Node prevOther, Node nextOther, Transaction transOther){
            prev = prevOther;
            next = nextOther;
            trans = transOther;
        }
    }

    public TransactionsLinkedList(){
        first = null;
        last = null;
        sizeList = 0;
    }
    public void addTransaction(Transaction transaction){
        Node tmpLast = last;
        Node newNode = new Node(last, null, transaction);
        last = newNode;
        if (first == null){
            first = newNode;
        } else {
            tmpLast.next = last;
        }
        sizeList++;
    }

    public void removeTransactionById(UUID id){
        int flag = 0;
        if (id == null) {
            throw new TransactionNotFoundException("Transaction with 'null' UUID can't be removed");
        }
        for(Node tmp = first; tmp != null; tmp = tmp.next){
            if(id.equals(tmp.trans.getIdentifier())){
                removeNode(tmp);
                flag = 1;
                break;
            }
        }
        if (flag == 0){
            throw new TransactionNotFoundException("Transaction with UUID: " + id + " not found.");
        }
    }

    void removeNode(Node delNode){
        if(first == delNode){
            if (last == delNode){
                first = null;
                last = null;
            } else {
                first =  delNode.next;
                delNode.next.prev = null;
            }
        } else {
            if (delNode.next != null) {
                delNode.prev.next = delNode.next;
                delNode.next.prev = delNode.prev;
            } else {
                delNode.prev.next = null;
                last = delNode.prev;
            }
        }
        sizeList--;
    }
    public Transaction[] toArray(){
        if (this.sizeList == 0) {
            return null;
        }
        Transaction[] result = new Transaction[this.sizeList];
        int i = 0;
        for (Node tmp = first; tmp != null; tmp = tmp.next) {
            result[i++] = tmp.trans;
        }
        return result;
    }

    public int getSize() {
        return sizeList;
    }

    public UUID getNodeId() {
        return last.trans.getIdentifier();
    }
}

