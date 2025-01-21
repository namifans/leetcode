class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
            if (arr[i].length() != 0 && i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}