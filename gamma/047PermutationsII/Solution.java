class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        return permuteUnique(nums, visited, new ArrayList(), new ArrayList());
    }

    private List<List<Integer>> permuteUnique(int[] nums, boolean[] visited, 
        List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList(current));
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;
            current.add(nums[i]);
            visited[i] = true;
            permuteUnique(nums, visited, current, result);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
        return result;
    }
}