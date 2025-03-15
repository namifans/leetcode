class Solution {
    public int calculate(String s) {
        int res = 0, current = 0, last = 0;
        char ops = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                current *= 10;
                current += c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (ops == '+') {
                    res += last;
                    last = current;
                } else if (ops == '-') {
                    res += last;
                    last = -current;
                } else if (ops == '*') {
                    last *= current;
                } else if (ops == '/') {
                    last /= current;
                }
                ops = c;
                current = 0;
            }
        }
        return res + last;
    }
}