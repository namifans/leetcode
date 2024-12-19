class MedianFinder {

    Queue<Integer> left;
    Queue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((x, y) -> (y - x));
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (left.isEmpty()) {
            left.add(num);
        } else {
            if (left.peek() >= num) {
                left.add(num);
                if (left.size() > right.size() + 1) {
                    right.add(left.remove());
                }
            } else {
                right.add(num);
                if (left.size() < right.size()) {
                    left.add(right.remove());
                }
            }
        }
    }
    
    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        } else {
            return  (left.peek() + right.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */