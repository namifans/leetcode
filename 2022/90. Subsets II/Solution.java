class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void subsets(int[] nums, int pos, List<Integer> cur, List<List<Integer>> res) {
        if (pos > nums.length)
            return;
        res.add(new ArrayList<>(cur));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            subsets(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}