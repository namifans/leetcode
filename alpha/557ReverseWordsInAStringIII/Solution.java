class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
        String[] arr = s.split(" ");
        if (arr.length == 0)
            return s;
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            StringBuilder current = new StringBuilder(str); 
            sb.append(current.reverse()).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}