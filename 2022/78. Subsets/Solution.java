class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void findSubsets(int[] nums, int pos, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList(current));
        for (int i = pos; i < nums.length; i++) {
            current.add(nums[i]);
            findSubsets(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}