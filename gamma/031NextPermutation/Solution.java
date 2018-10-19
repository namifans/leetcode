class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        int l = nums.length - 2, r = nums.length - 1;
        while (l > 0) {
            if (nums[l] < nums[r])
                break;
            l--;
            r--;
        }
        r = nums.length - 1;
        while (r > l) {
            if (nums[r] > nums[l])
                break;
            r--;
        }
        if (l == r)
            l -= 1;
        else {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        Arrays.sort(nums, l + 1, nums.length);
    }
}