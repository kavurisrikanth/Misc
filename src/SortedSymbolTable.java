import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

class SortedSymbolTable<KeyType extends Comparable<KeyType>, ValType extends Comparable<ValType>> {

    private ResizableArray<KeyType> keys;
    private ResizableArray<ValType> vals;

    public SortedSymbolTable() {
        keys = new ResizableArray<KeyType>();
        vals = new ResizableArray<ValType>();
    }

    public void put(KeyType key, ValType val) throws Exception {

        if(keys.isEmpty()) {
            keys.addAt(key, 0);
            vals.addAt(val, 0);
            return;
        }

        int ind = keys.searchFor(key);
        if(ind >= keys.size()) {
            keys.addAt(key, ind);
            vals.addAt(val, ind);
        } else {
            if(keys.peekAt(ind).compareTo(key) != 0) {
                keys.addAt(key, ind);
                vals.addAt(val, ind);
                return;
            }
            vals.replace(ind, val);
        }
    }

    public ValType get(KeyType key) throws Exception {
        int ind = keys.searchFor(key);
        System.out.println(key + " is at " + ind);
        if(ind >= keys.size())
            System.out.println(key + " does not exist");

        System.out.println("Returning " + vals.peekAt(ind));
        return vals.peekAt(ind);
    }

    public void remove(KeyType key) throws Exception {
        int ind = keys.searchFor(key);

        if(ind >= keys.size())
            throw new Exception("Nothing there to remove");

        if(keys.peekAt(ind).compareTo(key) != 0)
            throw new Exception("Element does not exist");

        System.out.println("Got index " + ind);

        vals.removeFrom(ind);
        keys.removeFrom(ind);
    }

    // Self-organizing search
    public void doSelfOrgSearch(KeyType key) throws Exception {
        int ind = keys.linearSearchFor(key);

        if(!keys.peekAt(ind).equals(key))
            throw new Exception(key + " does not exist");

        KeyType thisKey = keys.peekAt(ind);
        ValType thisVal = vals.peekAt(ind);

        keys.removeFrom(ind);
        vals.removeFrom(ind);

        keys.addAt(thisKey, 0);
        vals.addAt(thisVal, 0);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < keys.size(); i++) {
            try {
                s.append(keys.peekAt(i) + " -> " + vals.peekAt(i) + "\n");
            } catch (Exception e) {
                continue;
            }
        }
        return s.toString();
    }
}
