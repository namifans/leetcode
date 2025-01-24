class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(start, end);
        swap(nums, randomIndex, end);
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        if (start >= end)
            return -1;
        int pivot = nums[end];
        int l = start, r = end - 1;
        while (l <= r) {
            if (nums[l] <= pivot) {
                l++;
            } else if (nums[r] > pivot) {
                r--;
            } else {
                swap(nums, l, r);
            }
        }
        swap(nums, l, end);
        return l;
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}