class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0, nums.length, new ArrayList<>(), new ArrayList<>());
    }

    public List<List<Integer>> subsets(int[] nums, int index, int n,
        List<Integer> current, List<List<Integer>> result) {
        if (current.size() <= n) {
            result.add(new ArrayList(current));
        }
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            subsets(nums, i + 1, n, current, result);
            current.remove(current.size() - 1);
        }
        return result;
    }
}