class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            switch(t) {
                case "+": {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first + second);
                } break;
                case "-": {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first - second);
                } break;
                case "*": {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first * second);
                } break;
                case "/": {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first / second);
                } break;
                default: {
                    stack.push(Integer.parseInt(t));
                }
            }
        }
        return stack.pop();
    }
}