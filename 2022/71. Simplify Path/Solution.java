class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        String[] paths = path.split("/");
        for(String s : paths) {
            if ("".equals(s) || ".".equals(s))
                continue;
            else if ("..".equals(s)) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(s);
            }
        }
        if (res.isEmpty() && stack.isEmpty()) {
            return "/";
        }
        while(!stack.isEmpty()) {
            res.insert(0, stack.pop());
            res.insert(0, "/");
        }
        return res.toString();
    }
}