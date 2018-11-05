class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        char[] arr = str.toCharArray();
        int sign = 1, i = 0;
        long result = 0;
        while (i < arr.length && arr[i] == ' ') {
            i++;
        }
        if (i < arr.length && arr[i] == '-') { 
            sign = -1;
            i++;
        } else if (i < arr.length && arr[i] == '+') {
            sign = 1;
            i++;
        }
        while (i < arr.length && (arr[i] - '0') >= 0 && (arr[i] - '0') <= 9) {
            if (result * 10 + (arr[i] - '0') > Integer.MAX_VALUE) {
                if (sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            } else {
                result = result * 10 + (arr[i++] - '0');
            }
        }
        return (int) result * sign;
    }
}