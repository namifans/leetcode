class Solution2 {
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        int max = 0, lp = 0, rp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                lp++;
            } else {
                rp++;
            }
            if (lp == rp) {
                max = Math.max(max, rp * 2);
            } else if (rp > lp) {
                lp = 0;
                rp = 0;
            }
        } 
        lp = 0; 
        rp = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '(') {
                lp++;
            } else {
                rp++;
            }
            if (lp == rp) {
                max = Math.max(max, lp * 2);
            } else if (lp > rp) {
                lp = 0;
                rp = 0;
            }
        } 
        return max;
    }
}