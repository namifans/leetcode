class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> modMap = new HashMap<>();
        int sum = 0;
        modMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int key = sum % k;
            if (modMap.containsKey(key)) {
                if (i - modMap.get(key) >= 2)
                    return true;
            } else {
                modMap.put(key, i); 
            }
        }
        return false;
    }
}