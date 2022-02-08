class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) 
            return "";
        char[] arr = s.toCharArray();
        int max = 0;
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            int left = findLongestPalindrom(arr, i - 1, i + 1);
            int right = findLongestPalindrom(arr, i, i + 1);
            System.out.println("i " + i + " left " + left + " right " + right);
            int l = i - left / 2;
            int r = i + left / 2;
            if (right > left) {
                l = i - right / 2 + 1;
                r = i + right / 2;
                left = right;
            }
            if (max < left) {
                max = left;
                res = s.substring(l, r + 1);
            }
        }
        return res;
    }
    
    private int findLongestPalindrom(char[] arr, int left, int right) {
        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            left--;
            right++;
        }
        return right - left - 2 + 1;
    }

}