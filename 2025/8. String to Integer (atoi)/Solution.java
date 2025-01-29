class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        long num = 0;
        char[] arr = s.trim().toCharArray(); // FIXME
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                num *= 10;
                num += arr[i] - '0';
                if (num > Integer.MAX_VALUE) {
                    if (sign == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            } else if ('-' == arr[i] && i == 0) {
                sign = -1;
            } else if ('+' == arr[i] && i == 0) {
                sign = 1;
            } else {
                break;
            }
        }
        return sign * (int) num;
    }
}