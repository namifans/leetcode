class Solution {
    public int titleToNumber(String columnTitle) {
        char[] arr = columnTitle.toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) 
                res *= 26;
            res += arr[i] - 64;
        }
        return res;
    }
}