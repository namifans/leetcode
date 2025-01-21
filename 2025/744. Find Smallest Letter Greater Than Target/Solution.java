class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int min = 27;
        char next = letters[0];
        for (char c : letters) {
            int d = c - target;
            if (d > 0 && d < min) {
                min = d;
                next = c;
            }
        }
        return next;
    }
}