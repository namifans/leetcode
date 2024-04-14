class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (k >= 0) {
            int fill = 0;
            if (i >= 0 && j >= 0) {
                if (nums1[i] >= nums2[j]) {
                    fill = nums1[i--];
                } else {
                    fill = nums2[j--];
                }
            } else if (i >= 0) {
                fill = nums1[i--];
            } else {
                fill = nums2[j--];
            }
            nums1[k--] = fill;
        }
    }
}