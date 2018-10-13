class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1, i = digits.length - 1;
        while (i >= 0) {
            int current = (carry + digits[i]) % 10;
            carry = (carry + digits[i]) / 10;
            digits[i--] = current;
        }
        if (carry != 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        } else {
            return digits;
        }
    }
}