class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            if (isInteger(ops[i])) {
                stack.push(Integer.parseInt(ops[i]));
            } else if ("+".equals(ops[i])) {
                int current = 0;
                if (stack.size() < 2) {
                    stack.push(0);
                } else {
                    int temp = stack.pop();
                    current += stack.peek();
                    current += temp;
                    stack.push(temp);
                    stack.push(current);
                }
            } else if ("D".equals(ops[i])) {
                int current = 0;
                if (stack.empty()) {
                    stack.push(current);
                } else {
                    current = 2 * stack.peek();
                    stack.push(current);
                }
            } else {
                stack.pop();
            }
        }
        while (!stack.empty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}