class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0, current = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                current *= 10;
                current += c - '0';
            } else {
                switch(c) {
                    case '+': {
                        sum += sign * current;
                        current = 0;
                        sign = 1;
                    } break;
                    case '-': {
                        sum += sign * current;
                        current = 0;
                        sign = -1;
                    } break;
                    case '(': {
                        stack.push(sum);
                        stack.push(sign);
                        sign = 1;
                        sum = 0;
                    } break;
                    case ')': {
                        sum += sign * current;
                        int prevSign = stack.pop();
                        int prevSum = stack.pop();
                        sum = prevSign * sum + prevSum;
                        current = 0;
                    } break;
                }
            }
        }
        return sum + sign * current;
    }
}