class Freq {
    public int seq;
    public int key;
    public int freq;
    public Freq(int seq, int key, int freq) {
        this.seq = seq;
        this.key = key;
        this.freq = freq;
    }
}
class FreqStack {
    
    Map<Integer, Integer> map;
    PriorityQueue<Freq> queue;
    int seq;
    
    public FreqStack() {
        map = new HashMap<>();
        queue = new PriorityQueue<>((Freq x, Freq y) -> {
            return y.freq == x.freq ? y.seq - x.seq : y.freq - x.freq;
        });
    }
    
    public void push(int val) {
        int freq = map.getOrDefault(val, 0) + 1;
        queue.add(new Freq(seq++, val, freq));
        map.put(val, freq);
    }
    
    public int pop() {
        Freq q = queue.remove();
        map.put(q.key, q.freq - 1);
        return q.key;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */