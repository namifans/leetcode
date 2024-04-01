class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        find(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void find(int[] nums, int pos, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        if (pos >= nums.length) {
            return;
        }
        for(int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            find(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}