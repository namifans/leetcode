public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty())
            return s;
        String[] arr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}