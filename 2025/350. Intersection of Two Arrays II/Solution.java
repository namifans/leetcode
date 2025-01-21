class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m1 = new HashMap<>();
        for (int i : nums1) {
            m1.put(i, m1.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (m1.containsKey(i) && m1.get(i) > 0) {
                list.add(i);
                m1.put(i, m1.get(i) - 1);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int n : list) {
            res[i++] = n;
        }
        return res;
    }
}