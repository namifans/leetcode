class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);            
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (k == 0) {
                if (e.getValue() >= 2)
                    result ++;
            } else {
                if (map.containsKey(e.getKey() + k))
                    result ++;
            }
        }
        return result;
    }
}