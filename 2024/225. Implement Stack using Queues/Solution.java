class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        refill();
        return q1.remove();
    }
    
    public int top() {
        refill();
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    private void refill() {
        if (q1.isEmpty() && !q2.isEmpty()) {
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */