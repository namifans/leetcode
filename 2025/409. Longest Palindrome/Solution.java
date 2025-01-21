class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for (char c : s.toCharArray()) {
            map[c] ++;
        }
        boolean odd = false;
        int evenCount = 0;
        for (int i : map) {
            if (i != 0) {
                if (i >= 2) {
                    evenCount += i / 2;
                } 
                if (i % 2 != 0) {
                    odd = true;
                }
            }
        }
        return (odd) ? (evenCount * 2) + 1 : (evenCount * 2);
    }
}