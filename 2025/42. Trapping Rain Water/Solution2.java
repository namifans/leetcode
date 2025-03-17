class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        int sum = 0;
        while (left <= right) {
            if (maxLeft <= maxRight) {
                maxLeft = Math.max(height[left], maxLeft);
                sum += maxLeft - height[left];
                left ++;
            } else {
                maxRight = Math.max(height[right], maxRight);
                sum += maxRight - height[right];
                right --;
            }
        }
        return sum;
    }
}