class NumArray {

    int[] sums;

    public NumArray(int[] nums) {
        this.sums = new int[nums.length + 1];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0)
            return sums[right];
        return sums[right] - sums[left - 1];
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */