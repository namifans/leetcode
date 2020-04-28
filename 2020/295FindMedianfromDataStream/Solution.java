class MedianFinder {

    Queue<Integer> max;
    Queue<Integer> min;

    /** initialize your data structure here. */
    public MedianFinder() {
        max = new PriorityQueue<>((x, y) -> y - x);
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        min.add(num);
        if (min.size() >= max.size()) {
            max.add(min.poll());
            min.add(max.poll());
        }
    }
    
    public double findMedian() {
        if (min.size() == max.size()) {
            return ((double) min.peek() + (double) max.peek()) / 2;
        } else {
            return min.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */