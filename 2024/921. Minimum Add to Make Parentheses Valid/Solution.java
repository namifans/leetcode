class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            if ('(' == c) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.peek() != '(' ) {
                    res++;
                } else {
                    stack.pop();
                }
            }
        }
        return res + stack.size();
    }
}