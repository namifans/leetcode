class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        findPermutation(nums, 0, used, new ArrayList<>(), res);
        return res;
    }

    public void findPermutation(int[] nums, int pos, boolean[] used, List<Integer> current, List<List<Integer>> res) {
        if (current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                findPermutation(nums, pos + 1, used, current, res);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}