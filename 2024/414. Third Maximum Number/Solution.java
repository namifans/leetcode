class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : set) {
            heap.add(i);
        }
        if (heap.size() < 3) {
            return heap.peek();
        }
        int count = 0;
        while (count < 2) {
            count++;
            heap.remove();
        }
        return heap.peek();
    }
}