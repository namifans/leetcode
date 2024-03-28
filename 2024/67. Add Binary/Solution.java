class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            carry = sum > 1 ? 1 : 0;
            sb.insert(0, sum % 2);
        }
        return sb.toString();
    }
}