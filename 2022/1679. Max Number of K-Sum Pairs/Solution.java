class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int n : nums) {
            if (map.containsKey(k - n)) {
                count++;
                if (map.get(k - n) == 1) {
                    map.remove(k - n);
                } else {
                    map.put(k - n, map.get(k - n) - 1);
                }
            } else 
                map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return count;
    }
}