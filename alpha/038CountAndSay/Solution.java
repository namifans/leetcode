class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = countAndAppend(s);
        }
        return s;
    }

    private String countAndAppend(String s) {
        StringBuilder sb = new StringBuilder();
        char current = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == current) {
                count++;
            } else {
                sb.append(count);
                sb.append(current);
                count = 1;
                current = s.charAt(i);
            }
        }
        sb.append(count);
        sb.append(current);
        return sb.toString();
    }
}