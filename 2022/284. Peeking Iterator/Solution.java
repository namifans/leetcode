// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> iterator;
    Queue<Integer> queue;
    
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        queue = new LinkedList<>();
        
    }
    
    private void refill() {
        if (queue.isEmpty() && iterator.hasNext()) {
            queue.add(iterator.next());
        }
    }
    
    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        refill();
        if (!queue.isEmpty()) {
            return queue.peek();
        } else {
            return 0;
        }
    }
    
    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        refill();
        Integer res = queue.remove();
        return res;
    }
    
    @Override
    public boolean hasNext() {
        if (queue.isEmpty() && !iterator.hasNext()) {
            return false;
        }
        return true;
    }
}