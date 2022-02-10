class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findPermute(nums, new HashSet<Integer>(), new ArrayList<Integer>(), result);
        return result;
    }
    
    private void findPermute(int[] nums, Set<Integer> indexSet,
                             List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!indexSet.contains(i)) {
                list.add(nums[i]);
                indexSet.add(i);
                findPermute(nums, indexSet, list, result);
                list.remove(list.size() - 1);
                indexSet.remove(i);
            }
        }
    }
}