class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int i = n1.length - 1, j = n2.length - 1, c = 0;
        while (i >= 0 || j >= 0 || c != 0) {
            int sum = c;
            if (i >= 0) {
                sum += n1[i--] - '0';
            }
            if (j >= 0) {
                sum += n2[j--] - '0'; 
            }
            if (sum > 9) {
                c = 1;
                sum %= 10;
            } else {
                c = 0;
            }
            sb.append(sum);
        }
        return sb.reverse().toString();
    }
}