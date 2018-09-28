// O(m + n)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int[] nums = new int[l1 + l2];
        int l = l1 + l2;
        int i = 0, j = 0, k = 0;
        double result = 0.0;
        while (i < l1 && j < l2) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        while (i < l1) {
            nums[k++] = nums1[i++];
        }
        while (j < l2) {
            nums[k++] = nums2[j++];
        }
        if (l % 2 == 0) {
            result = (nums[l / 2 - 1] + nums[l / 2]) / 2.0;
        } else {
            result = nums[l / 2];
        }
        return result;
    }
}