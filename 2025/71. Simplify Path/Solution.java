class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if (s.length() == 0 || ".".equals(s))
                continue;
            else if ("..".equals(s)) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(s);
            }
        }
        if (stack.isEmpty())
            return "/";
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }
}