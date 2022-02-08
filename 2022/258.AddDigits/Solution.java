class Solution {
    public int addDigits(int num) {
        if (num == 0)
            return 0;
        int res = 0;
        while (num != 0) {
            int cur = num - num / 10 * 10;
            res += cur;
            num /= 10;
            if (num == 0 && res >= 10) {
                num = res;
                res = 0;
            } 
        }
        return res;
    }
}