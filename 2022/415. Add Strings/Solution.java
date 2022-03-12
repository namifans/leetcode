class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        StringBuilder sum = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int s = carry;
            if (i >= 0) {
                s += (int) (num1.charAt(i--) - '0');
            }
            if (j >= 0) {
                s += (int) (num2.charAt(j--) - '0');
            }
            carry = s > 9 ? 1 : 0;
            sum.insert(0, (s % 10));
        }
        return sum.toString();
    }
}