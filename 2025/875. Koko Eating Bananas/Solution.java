class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int p : piles) {
            high = Math.max(high, p);
        }
        while (low < high) {
            int k = low + (high - low) / 2;
            int sum = 0;
            for (int i = 0; i < piles.length; i++) {
                if (piles[i] <= k) {
                    sum++;
                } else {
                    sum += piles[i] / k;                    
                    if (piles[i] % k != 0)
                        sum ++;
                }
            }
            if (sum <= h) {
                high = k;
            } else {
                low = k + 1;
            }
        }
        return high;
    }
}