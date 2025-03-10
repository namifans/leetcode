class Solution {
    public boolean isNumber(String s) {
        char[] arr = s.toCharArray();
        boolean num = false, exp = false, dot = false;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && arr[i - 1] != 'E' && arr[i - 1] != 'e') {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                if (exp || !num)
                    return false;
                exp = true;
                num = false;
            } else if (c == '.') {
                if (exp || dot)
                    return false;
                dot = true;
            } else {
                return false;
            }
        }
        return num;
    }
}