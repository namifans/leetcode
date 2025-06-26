class Solution {
    public boolean isValid(String s) {
        char[] a = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : a) {
            if (!stack.isEmpty())
                System.out.println("c " + c + " s " + stack.peek());
            switch (c) {
                case ')': { 
                    if (stack.isEmpty() || '(' != stack.peek()) {
                        return false;
                    } else {
                        stack.pop();
                    }
                } break;
                case ']': { 
                    if (stack.isEmpty() || '[' != stack.peek()) {
                        return false;
                    } else {
                        stack.pop();
                    }
                } break;
                case '}': {
                    if (stack.isEmpty() || '{' != stack.peek()) {
                        return false;
                    } else {
                        stack.pop();
                    }
                    
                } break;
                default: {
                    stack.push(c);
                } break;
            }
        }
        return stack.isEmpty();
    }
}