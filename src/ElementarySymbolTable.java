/*
    Basic version of a symbol table.
    Uses a linked list, and the list is not in order.
*/

class ElementarySymbolTable<KeyType, ValType> {

    private STLinkedList<KeyType, ValType> data;

    public ElementarySymbolTable() {
        data = new STLinkedList<KeyType, ValType>();
    }

    public void add(KeyType key, ValType val) {
        //System.out.println("Inserting...");
        data.insert(key, val);
    }

    public void remove(KeyType key) {
        data.remove(key);
    }

    public ValType get(KeyType key) throws Exception {
        return data.get(key);
    }

    public String toString() {
        //System.out.println("Printing...");
        return data.toString();
    }
}
