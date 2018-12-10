class UnionFind {
    int[] father = null;
    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    public void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx != ry) {
            father[rx] = ry;
        }
    }
    public int getMax() {
        int[] count = new int[father.length];
        int max = 0;
        for (int i = 0; i < father.length; i++) {
            count[find(i)]++;
            max = Math.max(max, count[find(i)]);
        }
        return max;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            map.put(nums[i], i);
            if (map.containsKey(nums[i] + 1)) {
                uf.union(i, map.get(nums[i] + 1));
            }
            if (map.containsKey(nums[i] - 1)) {
                uf.union(i, map.get(nums[i] - 1));
            }
        }
        return uf.getMax();
    }
}