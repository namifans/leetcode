class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return findPermute(nums, new ArrayList<>(), new ArrayList<>());
    }

    public List<List<Integer>> findPermute(int[] nums, 
        List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList(current));
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (current.contains(nums[i]))
                continue;
            current.add(nums[i]);
            findPermute(nums, current, result);
            current.remove(current.size() - 1);
        }
        return result;
    }
}