import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.Iterator;

class STLinkedList<KeyType, ValType> {

    private int numNodes;
    private Node<KeyType, ValType> head, tail;

    public STLinkedList() {
        numNodes = 0;
        head = null;
        tail = null;
    }

    public void insert(KeyType key, ValType val) {

        Node<KeyType, ValType> temp = head;

        // Look through the list and check if the current key
        // exists
        while(temp != null) {
            if(temp.getKey().equals(key)) {
                /* System.out.println("Compared " + temp.getKey() + " and " + key);
                System.out.println("Updating"); */
                temp.setValue(val);
                return;
            }
            temp = temp.getNext();
        }

        // Node doesn't exist. Add it.
        /* System.out.println("Fresh insert"); */
        temp = new Node<KeyType, ValType>(key, val);
        temp.setNext(head);
        head = temp;
        if(tail == null)
            tail = temp;

        numNodes++;
    }

    public void remove(KeyType key) {

        if(head == null)
            return;

        if(head.getKey().equals(key)) {
            head = head.getNext();
            return;
        }

        Node<KeyType, ValType> temp = head;
        while(temp.getNext() != null && !temp.getNext().getKey().equals(key)) {
            temp = temp.getNext();
        }

        if(temp.getNext() == null) return;

        temp.setNext(temp.getNext().getNext());
    }

    public ValType get(KeyType key) throws Exception {
        Node<KeyType, ValType> temp = head;
        while(temp != null && !temp.getKey().equals(key)) {
            temp = temp.getNext();
        }

        if(temp == null)
            throw new Exception(key + " doesn't exist");

        return temp.getValue();
    }

    public String toString() {
        String ans = "";
        Node<KeyType, ValType> temp = head;
        while(temp != null) {

            ans += temp.toString();
            if(temp.getNext() != null)
                ans += ", ";

            temp = temp.getNext();
        }
        ans.trim();
        return ans;
    }
}
