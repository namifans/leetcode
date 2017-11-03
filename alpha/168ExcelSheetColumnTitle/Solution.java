class Solution {
    public String convertToTitle(int n) {
        if (n <= 0)
            return "";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + (int) 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}