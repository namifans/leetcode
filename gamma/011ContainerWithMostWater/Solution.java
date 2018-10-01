class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l != r) {
            int low = height[l] > height[r] ? height[r] : height[l];
            if (low * (r - l) >= max) {
                max = low * (r - l); 
            } 
            if (height[l] < height[r])
                l++;
            else {
                r--;
            }
        }
        return max;
    }
}