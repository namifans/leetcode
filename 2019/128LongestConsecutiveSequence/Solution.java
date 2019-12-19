class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int l = map.getOrDefault(n - 1, 0);
                int r = map.getOrDefault(n + 1, 0);
                int c = r + l + 1;
                max = Math.max(c, max);
                map.put(n, c);
                if (map.containsKey(n - l)) {
                    map.put(n - l, c);
                }
                if (map.containsKey(n + r)) {
                    map.put(n + r, c);
                }
            }
        }
        return max;
    }
}