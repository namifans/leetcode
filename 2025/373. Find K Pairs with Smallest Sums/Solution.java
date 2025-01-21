class SumPair {
    public int i;
    public int j;
    public int sum; 
    public SumPair(int i, int j, int sum) {
        this.i = i;
        this.j = j;
        this.sum = sum;
    }
    @Override
    public int hashCode() {
        return i * 31 ^ j;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof SumPair) {
            SumPair other = (SumPair) o;
            return (i == other.i && j == other.j);
        }
        return false;
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Set<SumPair> set = new HashSet<>();
        Queue<SumPair> heap = new PriorityQueue<>((x, y) -> (x.sum - y.sum));
        heap.add(new SumPair(0, 0, nums1[0] + nums2[0]));
        while (!heap.isEmpty() && k > 0) {
            k--;
            SumPair sp = heap.remove();
            int i = sp.i, j = sp.j;
            res.add(Arrays.asList(new Integer[]{nums1[i], nums2[j]}));
            if (i < nums1.length - 1) {
                SumPair nsp = new SumPair(i + 1, j, nums1[i + 1] + nums2[j]);
                if (!set.contains(nsp)) {
                    heap.add(nsp);
                    set.add(nsp);
                }
            }
            if (j < nums2.length - 1) {
                SumPair nsp = new SumPair(i, j + 1, nums1[i] + nums2[j + 1]);
                if (!set.contains(nsp)) {
                    heap.add(nsp);
                    set.add(nsp);
                }
            }
        }
        return res;
    }
}