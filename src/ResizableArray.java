/*
    Resizable array
*/

class ResizableArray<Gen extends Comparable<Gen>> {

    private Gen[] stuff;
    private int capacity, filled, startAt, endAt;

    // Constructor
    public ResizableArray() {
        capacity = 10;
        stuff = (Gen[])(new Comparable[capacity]);
        filled = 0;
        startAt = 0;
        endAt = -1;
    }

    // Add to the end of the array
    public void append(Gen what) {
        try {
            addAt(what, endAt + 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Add something somewhere
    public void addAt(Gen what, int where) throws Exception {

        System.out.println("insert " + what + " at " + where);

        if(where < 0)
            throw new Exception("Can't insert there.");

        if(!(where >= startAt && where <= endAt + 1))
            throw new Exception("Insert has to be between the limits");

        if(where <= endAt)
            slide(where, endAt, true);

        endAt = (where <= endAt) ? endAt + 1 : where;
        stuff[where] = what;

        if((float)++filled/capacity >= 0.8)
            resize(false);
    }

    public void replace(int where, Gen withWhat) {
        // It's assumed that validations are correctly performed
        // before this call
        stuff[where] = withWhat;
    }


    public void remove(Gen what) throws Exception {

        int ind = searchFor(what);
        if(ind >= filled) throw new Exception("Nothing there to remove");

        if(stuff[ind].compareTo(what) != 0)
            throw new Exception("Element does not exist");

        removeFrom(ind);
    }

    public void removeFrom(int where) throws Exception {

        if(where != filled - 1) {
            slide(where, filled - 1, false);
        }

        --filled;
        --endAt;
    }

    // Slide elements over one place to make room
    private void slide(int from, int to, boolean right) {
        System.out.println("from: " + from + ", to: " + to);

        if(right) {
            for (int i = to; i >= from; i--) {
                stuff[i + 1] = stuff[i];
            }
        } else {
            for(int i = from + 1; i <= to; i++) {
                stuff[i - 1] = stuff[i];
            }
        }
    }

    // Bisection search
    public int searchFor(Gen what) {
        int from = startAt, to = endAt, mid = 0, cmp;

        //System.out.println("from: " + from + ", to: " + to);

        do {
            mid = (from + to)/2;

            cmp = stuff[mid].compareTo(what);

            if(cmp == 0)
                return mid;

            if(cmp > 0)
                to = mid - 1;
            else
                from = mid + 1;
        } while(from <= to);

        return from;
    }


    public int linearSearchFor(Gen what) throws Exception {
        int i = startAt;
        for(i = startAt; i <= endAt; i++)
            if(stuff[i].compareTo(what) == 0) return i;

        throw new Exception(what + " does not exist");
    }


    // Empty check
    public boolean isEmpty() {
        return filled == 0;
    }

    // Resize function
    private void resize(boolean shrink) {

        int newCap = 0;
        if(shrink) {
            newCap = capacity/2;
        } else {
            newCap = capacity*2;
        }

        Gen[] newStuff = (Gen[])new Comparable[newCap];
        //System.out.println("Start: " + startAt + ", end: " + endAt + ", filled: " + filled + ", capacity: " + capacity);
        System.arraycopy(stuff, 0, newStuff, 0, shrink ? newCap : capacity);

        stuff = newStuff;
        capacity = newCap;
    }

    // Get the size (number of elements filled so far)
    public int size() { return filled; }

    public Gen peekAt(int ind) throws Exception {
        if(ind < startAt) throw new Exception("Underflow");

        return stuff[ind];
    }

    // Print
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(int i = startAt; i <= endAt; i++) {
            if(stuff[i] != null)
                s.append(stuff[i] + " ");
        }
        return s.toString();
    }
}
