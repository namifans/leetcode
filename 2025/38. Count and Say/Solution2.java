class Solution {
    public String countAndSay(int n) {
        String say = "1";
        for (int i = 2; i <= n; i++) {
            say = coundAndSayHelper(say);
        }
        return say;
    }

    private String coundAndSayHelper(String s) {
        StringBuilder sb = new StringBuilder();
        int sum = 1, i = 0;
        while (i < s.length()) {
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                sum++;
            } else {
                sb.append(sum);
                sb.append(s.charAt(i));
                sum = 1;
            }
            i++;
        }
        return sb.toString();
    }
}