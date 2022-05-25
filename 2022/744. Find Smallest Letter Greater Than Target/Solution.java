class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (letters[m] - 'a' > target - 'a') {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l == letters.length ? letters[0] : letters[l];
    }
}