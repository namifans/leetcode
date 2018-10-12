class Solution {
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < arr.length) {
            if (stack.isEmpty()) {
                stack.push(i++);
                continue;
            }
            if (arr[stack.peek()] == '(' && arr[i] == ')') {
                stack.pop();
            } else {
                stack.push(i);
            }
            i++;
        }
        if (stack.isEmpty()) 
            return arr.length;
        i = arr.length - 1;
        while (!stack.isEmpty()) {
            int j = stack.pop();
            max = Math.max(i - j, max);
            i = j - 1;
        }
        max = Math.max(max, i + 1);
        return max;
    }
}