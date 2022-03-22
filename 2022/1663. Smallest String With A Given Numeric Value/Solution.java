class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        k -= n;
        int i = 26;
        while (i >= 2 && k >= 0) {
            if (k + 1 >= i) { 
                char c = (char) (i + 96);
                sb.insert(0, c);
                k -= (i - 1);
            } else 
                i--;
        }
        while (sb.length() < n) {
            sb.insert(0, 'a');
        }
        return sb.toString();
    }
}