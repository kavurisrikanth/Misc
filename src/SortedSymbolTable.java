class SortedSymbolTable<KeyType, ValType> {

    private ResizableArray<KeyType> keys;
    private ResizableArray<ValType> vals;

    public SortedSymbolTable() {
        keys = new ResizableArray<KeyType>();
        vals = new ResizableArray<ValType>();
    }


}
