class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // keep num1 as the smaller input
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int n = nums1.length, m = nums2.length, half = (n + m + 1) / 2;
        int l = 0, r = n; // right is nums1.length which is smaller n
        boolean isEven = (n + m) % 2 == 0;
        while (l <= r) { // binary search smaller array
            int mid1 = (l + r) / 2;
            int mid2 = half - mid1;
            int nums1Left = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int nums1Right = mid1 == n ? Integer.MAX_VALUE : nums1[mid1];
            int nums2Left = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int nums2Right = mid2 == m ? Integer.MAX_VALUE : nums2[mid2];
            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                if (isEven) {
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                } else {
                    return Math.max(nums1Left, nums2Left);
                }
            } else if (nums1Left > nums2Right) {
                r = mid1 - 1;
            } else {
                l = mid1 + 1;
            }
        }
        return 0.0;
    }
}