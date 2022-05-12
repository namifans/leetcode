class MyStack {
    
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        if (q1.isEmpty())
            q2.add(x);
        else
            q1.add(x);
    }
    
    public int pop() {
        int res = 0;
        if (q2.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            res = q1.remove();
        } else {
            while (q2.size() > 1) {
                q1.add(q2.remove());
            }
            res = q2.remove();
        }
        return res;
    }
    
    public int top() {
        int res = 0;
        if (q2.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            res = q1.remove();
            q2.add(res);
        } else {
            while (q2.size() > 1) {
                q1.add(q2.remove());
            }
            res = q2.remove();
            q1.add(res);
        }
        return res;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
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