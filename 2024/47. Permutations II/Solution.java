class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        findPermutation(nums, new boolean[nums.length], new ArrayList<>(), res);
        return new ArrayList<>(res);
    }

    public void findPermutation(int[] nums, boolean[] map, List<Integer> current, Set<List<Integer>> res) {
        if (current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (map[i] == true) {
                continue;
            }
            map[i] = true;
            current.add(nums[i]);
            findPermutation(nums, map, current, res);
            current.remove(current.size() - 1);
            map[i] = false;
        }
    
    }
}