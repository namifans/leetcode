class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                set2.add(i);
            }
        }
        int[] res = new int[set2.size()];
        Iterator<Integer> itr = set2.iterator();
        int i = 0;
        while (itr.hasNext()) {
            res[i++] = itr.next().intValue();
        }
        return res;
    }
}