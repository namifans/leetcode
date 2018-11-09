class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return helper(nums, 0, new ArrayList<>(), new ArrayList<>());
    }

    public List<List<Integer>> helper(int[] nums, int index, List<Integer> current, List<List<Integer>> list) {
        list.add(new ArrayList<>(current));
        int i = index;
        while (i < nums.length) {
            current.add(nums[i]);
            helper(nums, i + 1, current, list);
            current.remove(current.size() - 1);
            i++;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return list;
    }
}