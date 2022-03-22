class Solution {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        k -= n;
        int i = 26, j = n - 1;
        while (i >= 2 && k >= 0) {
            if (k + 1 >= i) { 
                char c = (char) (i + 96);
                res[j--] = c;
                k -= (i - 1);
            } else 
                i--;
        }
        while (j >= 0) {
            res[j--] = 'a';
        }
        return new String(res);
    }
}