/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *                1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, h = n;
        while (l <= h) {
            int m = l + (h - l) / 2;
            int g = guess(m);
            if (g == 0) {
                return m;
            } else if (g == -1) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}