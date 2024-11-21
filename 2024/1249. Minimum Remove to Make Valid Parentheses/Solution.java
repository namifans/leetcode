class Pair {
    public char c;
    public int pos;
    public Pair(char c, int pos) {
        this.c = c;
        this.pos = pos;
    }
}
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Pair> stack = new Stack<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(new Pair('(', i));
            } else if (arr[i]  == ')') {
                if (!stack.isEmpty() && stack.peek().c == '(') {
                    stack.pop();
                } else {
                    set.add(i);
                }
            } 
        }
        while (!stack.isEmpty()) {
            set.add(stack.pop().pos);
        }
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(i)) {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}