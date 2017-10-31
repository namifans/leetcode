class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0)
            return result;
        traverse(nums, 0, result, new ArrayList<Integer>());
        return result;
    }

    private void traverse(int[] nums, int index, List<List<Integer>> result, List<Integer> current) {
        result.add(new ArrayList<Integer>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            traverse(nums, i + 1, result, current);
            current.remove(current.size() - 1);
        }
    }
}