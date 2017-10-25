class ResizableArray<Gen> {

    private int capacity, filled;
    private Gen[] stuff;

    public ResizableArray() {
        capacity = 10;
        stuff = (Gen[])new Object[capacity];
        filled = 0;
    }

    public void addAt(Gen what, int where) {
        // adds what at where

        stuff[where] = what;

//        ++filled;

         if((float)(++filled)/capacity >= 0.8)
             resize(false);
    }

    public Gen removeFrom(int where) {
        // removes element from where
        Gen ans = stuff[where];

//        --filled;

         if((float)(--filled)/capacity <= 0.25)
             resize(true);

        return ans;
    }

    public boolean isEmpty() {
        return filled == 0;
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return filled;
    }

    public Gen peekAt(int where) {
        // Returns the item at where, but doesn't delete it
        // Used for printing
        return stuff[where];
    }

    /*
    public void expand(int fromOne, int toOne, int fromTwo, int toTwo) {
        // Increases the size of the array, and copies stuff
        // according to the froms and tos

        // System.out.println("entered expand");
        // System.out.println(fromOne + " " + toOne + " " + fromTwo + " " + toTwo);

        int newcap = capacity * 2;
        Gen[] newstuff = (Gen[])new Object[newcap];

        // copy stuff one
        int j = 0;
        for(int i = fromOne; i < toOne; i++)
            newstuff[j++] = stuff[i];

        j = newstuff.length;
        for(int i = fromTwo; i >= toTwo; i--)
            newstuff[--j] = stuff[i];

        stuff = newstuff;
        capacity = newcap;
    }
    */

    private void resize(boolean shrink) {
        // resizes the array

        int newcap = 0;

        if(shrink) {
            // make the array smaller
            newcap = capacity/2;

        } else {
            // Make the array bigger
            newcap = capacity * 2;
        }

        Gen[] newstuff = (Gen[])new Object[newcap];
        for(int i = 0; i < filled; i++)
            newstuff[i] = stuff[i];

        capacity = newcap;
        stuff = newstuff;
    }

    public void swap(int one, int two) {
        Gen temp = stuff[one];
        stuff[one] = stuff[two];
        stuff[two] = temp;
    }

    public String toString() {
        String ans = "[";
        for(int i = 0; i < filled; i++) {
            ans += stuff[i];
            if(i != filled - 1)
                ans += ", ";
        }
        ans += "]";

        return ans;
    }
}