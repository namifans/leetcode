class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            if (set1.contains(n)) {
                set2.add(n);
            }
        }
        int i = 0;
        int[] r = new int[set2.size()];
        for (Integer in : set2) {
            r[i++] = in;
        }
        return r; 
    }
}