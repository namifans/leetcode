class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j < nums.length - 1 && nums[j] + 1 == nums[j + 1]) {
                continue;
            } 
            res.add(generateRange(nums, i, j));
            i = j + 1;
        }
        return res;
    }
    
    private String generateRange(int[] nums, int i, int j){
        if (i == j) 
            return nums[i] + "";
         else
            return nums[i] + "->" + nums[j];
    }
}