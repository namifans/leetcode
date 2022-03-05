class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
            map.put(n, map.getOrDefault(n, 0) + n);
        }
        int earn = 0, del = 0;
        for (int i = 0; i <= max; i++) {
            int cur = map.getOrDefault(i, 0);
            int pick = del + cur;
            int skip = Math.max(earn, del);
            earn = pick;
            del = skip;
        }
        return Math.max(earn, del);
    }
}