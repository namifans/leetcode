class MovingAverage {

    List<Integer> list;
    int size;
    int sum;

    public MovingAverage(int size) {
        this.list = new ArrayList<>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        sum += val;
        list.add(val);
        if (list.size() > size) {
            sum -= list.removeFirst();
        }
        return (double) sum / list.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */