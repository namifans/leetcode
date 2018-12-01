class Pair {
    private int[] pair;
    private int sum;
    private int idx; // store idx of nums2
    public Pair(int n1, int n2, int idx) {
        this.pair = new int[]{n1, n2};
        this.sum = n1 + n2;
        this.idx = idx;
    }
    public int[] getPair() {
        return pair;
    }
    public int getSum() {
        return sum;
    }
    public int getIdx() {
        return idx;
    }
}

/**
* O(klogk)
*/
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> pairList = new LinkedList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return pairList;
        Queue<Pair> pairHeap = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.getSum() - p2.getSum();
            };
        });
        for (int i = 0; i < nums1.length && i < k; i++) {
            pairHeap.add(new Pair(nums1[i], nums2[0], 0));
        }
        for (int i = 1; i <= k && !pairHeap.isEmpty(); i++) {
            Pair p = pairHeap.poll();
            pairList.add(p.getPair());
            if (p.getIdx() + 1 < nums2.length) {
                pairHeap.add(new Pair(p.getPair()[0], nums2[p.getIdx() + 1], p.getIdx() + 1));
            }
        }
        return pairList;
    }
}