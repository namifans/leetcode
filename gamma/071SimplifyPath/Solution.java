class Solution {
    public String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if (s == null || s.isEmpty() || s.equals(".")) {
                continue;
            }
            stack.push(s);
        } 
        int up = 0;
        while(!stack.isEmpty()) {
            if (stack.peek().equals("..")) {
                up++;
                stack.pop();
            } else {
                if (up > 0) {
                    stack.pop();
                    up--;
                    continue;
                }
                result.insert(0, "/" + stack.pop());
            }
        }
        if (result.length() == 0)
            result.append("/");
        return result.toString();
    }
}