class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        findCombination(nums, 0, target, visited, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void findCombination(int[] nums, int pos, int target, boolean[] visited,
                                 List<Integer> list, List<List<Integer>> result) {
        
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                findCombination(nums, i, target - nums[i], visited, list, result);
                list.remove(list.size() - 1); 
                visited[i] = false;
            }
        } 
    }
}