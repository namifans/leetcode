class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        find(nums, 0, set, new ArrayList<>());
        return new ArrayList<>(set);
    }

    private void find(int[] nums, int pos, Set<List<Integer>> set, List<Integer> list) {
        if (pos > nums.length)
            return;
        set.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            find(nums, i + 1, set, list);
            list.remove(list.size() - 1);
        }
    }
}