class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";
        String r = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder cur = new StringBuilder();
            for (int j =  num2.length() - 1; j >= 0; j--) {
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                prod += carry;
                carry = prod / 10;
                cur.insert(0, prod % 10);
            }
            if (carry != 0)
                cur.insert(0, carry);
            for (int k = 0; k < num1.length() - i - 1; k++) {
                cur.append(0);
            }
            r = add(r, cur.toString());
        }
        return r;
    }
    
    private String add(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            carry += i >= 0 ? num1.charAt(i--) - '0' : 0;
            carry += j >= 0 ? num2.charAt(j--) - '0' : 0;
            sb.insert(0, carry % 10);
            carry = carry > 9 ? 1 : 0;
        }
        return sb.toString();
    }
}
