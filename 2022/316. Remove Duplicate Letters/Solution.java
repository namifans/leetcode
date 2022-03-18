class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>(); 
        int[] map = new int[26], set = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set[c - 'a'] == 0) {
                while (!stack.isEmpty() && map[stack.peek() - 'a'] > i && stack.peek() > c) {
                    set[stack.peek() - 'a'] = 0;
                    stack.pop();
                }
                stack.push(c);
                set[c - 'a'] = 1;
            }
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}