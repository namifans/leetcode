public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
        	char c = '\0';
        	if (!stack.empty())
        		c = stack.peek();
        	switch(s.charAt(i)) {
        		case '}': {
        			if (c == '{')
        				stack.pop();
        			else 
        				return false;
        		} break;
        		case ']': {
        			if (c == '[')
        				stack.pop();
        			else 
        				return false;
        		} break;
        		case ')': {
        			if (c == '(')
        				stack.pop();
        			else 
        				return false;
        		} break;
        		default: {
        			stack.push(s.charAt(i));
        		} break;
        	}
        }
        if (stack.empty())
        	return true;
    	else
    		return false;
    }
}