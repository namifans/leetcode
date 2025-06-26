class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int c = 0, i = a.length() - 1, j = b.length() - 1;
        while(i >= 0 || j >= 0) {
            int sum = c;
            if (i >= 0)
                sum += a.charAt(i--) - '0';
            if (j >= 0)
                sum += b.charAt(j--) - '0';
            c = sum / 2;
            sum = sum % 2;
            sb.append(sum);
        }
        if (c != 0) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}