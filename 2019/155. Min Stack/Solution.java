class MinStack {

    Stack<Integer> s;
    Stack<Integer> ms;

    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
        ms = new Stack<>();
    }
    
    public void push(int x) {
        s.push(x);
        if (ms.isEmpty()) {
            ms.push(x);
        } else {
            if (ms.peek() > x) {
                ms.push(x);
            } else {
                ms.push(ms.peek());
            }
        }
    }
    
    public void pop() {
        s.pop();
        ms.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return ms.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */