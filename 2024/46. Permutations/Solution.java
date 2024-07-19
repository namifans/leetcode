class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] map = new int[nums.length];
        findPermutation(nums, 0, map, new ArrayList<>(), res);
        return res;
    }

    public void findPermutation(int[] nums, int pos, int[] map, List<Integer> current, List<List<Integer>> res) {
        if (current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (map[i] == 1)
                continue;
            map[i] = 1;
            current.add(nums[i]);
            findPermutation(nums, pos + 1, map, current, res);
            current.remove(current.size() - 1);
            map[i] = 0;
        }
    }
}