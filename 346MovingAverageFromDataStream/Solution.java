public class MovingAverage {
	
	int[] queue;
	int current;
	double sum;
	int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new int[size];
        this.size = 0;
        this.current = 0;
        this.sum = 0;
    }
    
    public double next(int val) {
		if (size < queue.length)
        	size ++;
    	int temp = (size >= queue.length) ? queue[current] : 0;
        queue[current] = val;
        sum += val - temp;
        current = (current+1) % queue.length;
        return sum / size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */