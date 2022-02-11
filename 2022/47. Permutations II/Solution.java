class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        findPermute(nums, new boolean[nums.length], new ArrayList<Integer>(), result);
        return result;
    }
    
    private void findPermute(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                findPermute(nums, visited, list, result);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}