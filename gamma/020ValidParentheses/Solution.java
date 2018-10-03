class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            switch(arr[i]) {
                case ')': {
                    if (stack.isEmpty() || stack.peek() != '(')
                        return false;
                    else
                        stack.pop();
                } break;
                case ']': {
                    if (stack.isEmpty() || stack.peek() != '[')
                        return false;
                    else
                        stack.pop();
                } break;
                case '}': {
                    if (stack.isEmpty() || stack.peek() != '{')
                        return false;
                    else
                        stack.pop();
                } break;
                default: {
                    stack.push(arr[i]);
                }
            }
        }
        return stack.isEmpty();
    }
}