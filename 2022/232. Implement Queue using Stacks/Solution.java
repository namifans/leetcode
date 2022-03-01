class MyQueue {
    
    Stack<Integer> reversedStack, normalStack;

    public MyQueue() {
        reversedStack = new Stack<>();
        normalStack = new Stack<>();
    }
    
    public void push(int x) {
        normalStack.push(x);
    }
    
    public int pop() {
        if (reversedStack.isEmpty()) {
            reverse();
        }
        return reversedStack.pop();
    }
    
    public int peek() {
        if (reversedStack.isEmpty()) {
            reverse();
        }
        return reversedStack.peek();
    }
    
    public boolean empty() {
        return reversedStack.isEmpty() && normalStack.isEmpty();
    }
    
    private void reverse() {
        while (!normalStack.isEmpty()) {
            reversedStack.push(normalStack.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */