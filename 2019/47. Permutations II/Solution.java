class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        findPermutation(nums, new HashSet<>(), new ArrayList<>(), result);
        return result;
    }

    public void findPermutation(int[] nums, Set<Integer> indice,
        List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList(list));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (indice.contains(i) || 
                    (i > 0 && nums[i] == nums[i - 1] 
                        && !indice.contains(i - 1))) {
                    continue;
                }
                indice.add(i);
                list.add(nums[i]);
                findPermutation(nums, indice, list, result);
                list.remove(list.size() - 1);
                indice.remove(i);
            }
        }
    }
}