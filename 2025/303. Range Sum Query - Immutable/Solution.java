class NumArray {

    Map<Integer, Integer> sumMap;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        sumMap = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumMap.put(i, sum);
        }
    }
    
    public int sumRange(int left, int right) {
        return sumMap.get(right) + nums[left] - sumMap.get(left);
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */