class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.trim().split(" ");
        for (String a : arr) {
            if (a.length() > 0) {
                sb.insert(0, a);
                sb.insert(0, " ");
            }
        }
        return sb.toString().substring(1, sb.length());
    }
}