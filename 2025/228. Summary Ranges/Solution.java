class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int i = 0, j = 1;
        while (j <= nums.length) {
            if (j < nums.length && nums[j] == nums[j - 1] + 1) {
                j++;
            } else {
                if (nums[i] != nums[j - 1]) {
                    list.add(nums[i] + "->" + nums[j - 1]);
                } else {
                    list.add(nums[i] + "");
                }
                i = j++;
            }
        }
        return list;
    }
}