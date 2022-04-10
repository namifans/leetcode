class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            switch(s) {
                case "+": {
                    int first = stack.pop();
                    int second = stack.peek();
                    stack.push(first);
                    stack.push(first + second);
                } break;
                case "D": {
                    stack.push(stack.peek() * 2);
                } break;
                case "C": {
                    stack.pop();
                } break;
                default: {
                    stack.push(Integer.parseInt(s));                    
                }
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}