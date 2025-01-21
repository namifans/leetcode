class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : arr) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            switch(c) {
                case '}': {
                    if (stack.peek() == '{')  
                        stack.pop();
                    else return false;
                } break;
                case ']': {
                    if (stack.peek() == '[')  
                        stack.pop();
                    else return false;
                } break; 
                case ')': {
                    if (stack.peek() == '(')  
                        stack.pop();
                     else return false;
                } break;
                default: {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}