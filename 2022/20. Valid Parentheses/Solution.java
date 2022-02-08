class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            switch(c) {
                case '}': {
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                }break;
                case ']': {
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                }break;
                case ')': {
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                }break;
                default: {
                    stack.push(c);
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}