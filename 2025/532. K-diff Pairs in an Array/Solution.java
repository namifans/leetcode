class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int t = map.get(nums[i]);
                String str = nums[t] + ":" + nums[i];
                set.add(str);
            }
            map.put(nums[i] + k, i);
        }
        return set.size();
    }
}