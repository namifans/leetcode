class Solution {
    Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int start, int end) {
        if (start >= end) {
            return nums[start];
        }
        int n = nums.length;
        int pivot = partition(nums, start, end);
        if (pivot < n - k) {
            return quickSelect(nums, k, pivot + 1, end);
        } else if (pivot > n - k) {
            return quickSelect(nums, k, 0, pivot - 1);
        } else {
            return nums[pivot];
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int left = start, right = end - 1;
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] >= pivot) {
                right--;
            }
            if (left <= right ) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        swap(nums, left, end);
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}