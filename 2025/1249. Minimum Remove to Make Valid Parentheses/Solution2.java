class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int deleted = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            } else if (arr[i]  == ')') {
                if (!stack.isEmpty() && arr[stack.peek()] == '(') {
                    stack.pop();
                } else {
                    deleted++;
                    continue;
                }
            }
            sb.append(arr[i]);
        }
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop() - deleted);
        }
        return sb.toString();
    }
}