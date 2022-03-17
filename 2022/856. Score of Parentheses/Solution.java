class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    stack.push('1');
                } else {
                    int cur = 0;
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        cur += stack.pop() - '0';
                    }
                    stack.pop();
                    stack.push((char) (cur * 2 + '0'));
                }
            }
        }
        while (!stack.isEmpty()) {
            score += (stack.pop() - '0');
        }
        return score;
    }
}