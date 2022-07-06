class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[26];
        int count = 0;
        for (char c : s.toCharArray()) {
            map[c - 'a'] ++;
            if (map[c - 'a'] % 2 != 0)
                count ++;
            else if (count > 0)
                count --;
        }
        return count <= 1;
    }
}