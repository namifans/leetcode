class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        int sum = 0;
        while (left <= right) {
            if (maxLeft <= maxRight) {
                if (height[left] < maxLeft) {
                    sum += maxLeft - height[left];
                } else {
                    maxLeft = height[left];
                }
                left ++;
            } else {
                if (height[right] < maxRight) {
                    sum += maxRight - height[right];
                } else {
                    maxRight = height[right];
                }
                right --;
            }
        }
        return sum;
    }
}