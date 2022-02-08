class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int leftSum = 0, rightSum = 0;
        int max = 0;
        for (int n : nums) {
            rightSum += n;
        }
        for (int i = 0; i <= nums.length; i++) {
            if (i > 0) {
                leftSum +=  nums[i - 1] == 0 ? 1 : 0;
                rightSum -= nums[i - 1];
            } 
            int sum = leftSum + rightSum;
            if (max < sum) {
                res.clear();
                max = Math.max(max, sum);
                res.add(i);
            } else if (max == sum) {
                res.add(i);
            }
        }
        return res;
    }
}