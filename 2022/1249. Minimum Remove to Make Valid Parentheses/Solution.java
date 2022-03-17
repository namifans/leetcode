class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Set<Integer> del = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    del.add(i);
                }
            } 
        }
        while (!stack.isEmpty()) {
            del.add(stack.pop());
        }
        for (int i = 0; i < s.length(); i++) {
            if (!del.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    
}