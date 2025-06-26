class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findPermutation(nums, new ArrayList<>(), result);
        return result;
    }

    public void findPermutation(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList(list));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) {
                    continue;
                }
                list.add(nums[i]);
                findPermutation(nums, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}