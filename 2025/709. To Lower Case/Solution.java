class Solution {
    public String toLowerCase(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int c = (int) arr[i];
            if (c >= 65 && c <= 90) {
                arr[i] = (char) (c + 32);
            }
        }
        return new String(arr);
    }
}