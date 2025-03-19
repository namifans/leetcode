class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new LinkedList<>();
        for (String s : arr) {
            if (s.length() == 0 || ".".equals(s))
                continue;
            else if ("..".equals(s)) {
                if (!stack.isEmpty())
                    stack.removeLast();
            } else {
                stack.addLast(s);
            }
        }
        if (stack.isEmpty())
            return "/";
        while (!stack.isEmpty()) {
            sb.append("/" + stack.removeFirst());
        }
        return sb.toString();
    }
}