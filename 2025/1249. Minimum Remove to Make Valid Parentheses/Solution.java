class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        Set<Integer> removeSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            } else if (arr[i]  == ')') {
                if (!stack.isEmpty() && arr[stack.peek()] == '(') {
                    stack.pop();
                } else {
                    removeSet.add(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            removeSet.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!removeSet.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}