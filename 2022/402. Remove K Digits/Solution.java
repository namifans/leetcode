class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray()) {
            while (!dq.isEmpty() && k > 0 && dq.peekLast() > c) {
                dq.removeLast();
                k--;
            } 
            dq.addLast(c);
        }
        while (k > 0) {
            dq.removeLast();
            k--;
        }
        while(!dq.isEmpty()) {
            char c = dq.removeFirst();
            if (!sb.isEmpty() || c != '0')
                sb.append(c); 
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}