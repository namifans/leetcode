class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(nums, 0, new ArrayList(), result);
        return result;
    }

    public void findSubsets(int[] nums, int cur, List<Integer> list, List<List<Integer>> result) {
        if (list.size() <= nums.length) {
            result.add(new ArrayList<>(list));
        }
        for (int i = cur; i < nums.length; i++) {
            list.add(nums[i]);
            findSubsets(nums, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}