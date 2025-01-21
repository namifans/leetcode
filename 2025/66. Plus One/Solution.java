class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1, sum = 0;
        int i = digits.length - 1; 
        while (i >= 0) {
            sum = carry + digits[i];
            carry = sum > 9 ? 1 : 0;
            digits[i--] = sum % 10;
        }
        if (carry > 0) {
            i = digits.length - 1;
            int[] res = new int[digits.length + 1];
            while (i >= 0) {
                res[i] = digits[i--];
            }
            res[0] = carry;
            return res;
        } else {
            return digits;
        }
    }
}