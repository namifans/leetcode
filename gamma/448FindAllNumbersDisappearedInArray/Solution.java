class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        for (int i = 0; i < nums.length; i++) {
            int d = Math.abs(nums[i]) - 1;
            if(nums[d] > 0)
                nums[d] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                res.add(i + 1);
        }
        return res;
    }
}