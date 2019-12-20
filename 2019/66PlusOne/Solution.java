class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = c + digits[i];
            c = sum / 10;
            sum %= 10;
            digits[i] = sum;
        }
        if (c == 1) {
            int[] nd = new int[digits.length + 1];
            for (int i = digits.length - 1; i >= 0; i--) {
                nd[i + 1] = digits[i];
            }
            nd[0] = c;
            return nd;
        } else {
            return digits;
        }
    }
}