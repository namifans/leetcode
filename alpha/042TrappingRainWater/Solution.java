class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[max])
                max = i;
        }
        int l = 0, r = height.length - 1;
        while (l < r && height[l] < height[l + 1]) {
            l++;
        }
        while (l < r && height[r] < height[r - 1]) {
            r--;
        }
        int total = 0;
        for (int i = l; l < max; i++) {
            if (height[l] > height[i]) {
                total += height[l] - height[i];
            } else {
                l = i;
            }
        }
        for (int i = r; r > max; i--) {
            if (height[r] > height[i]) {
                total += height[r] - height[i];
            } else {
                r = i;
            }
        }
        return total;
    }
}